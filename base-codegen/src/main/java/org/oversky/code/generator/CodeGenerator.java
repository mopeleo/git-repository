package org.oversky.code.generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import org.oversky.code.model.Model;
import org.oversky.code.model.Table;
import org.oversky.code.parser.CDMParser;
import org.oversky.code.parser.PDMParser;
import org.oversky.code.util.PropertiesUtil;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class CodeGenerator {

    protected PropertiesUtil util = null;
    
    protected String getClassPath(){
        return CodeGenerator.class.getClassLoader().getResource("").getPath();
    }
    
    protected String getConfig(String key) {
        if(util == null){
        	util = new PropertiesUtil(ResourceBundle.getBundle("config"));
        }
        String val =  util.getValue(key);
        if(val == null) {
        	val = "";
        }
        return val;
    }
    
    public String getTemplateDir(){
        return getConfig("template_dir").trim();
    }

    public String getGenerateType(){
    	return getConfig("generate_type").trim();
    }
    
    public String getModelFile(){
        return getConfig("model_file").trim();
    }

    public String getModelPackage() {
    	return getConfig("model_package").trim();
    }

    public String getModelExclude() {
    	return getConfig("model_exclude").trim();
    }
    
    public void addGlobalParam(Map<String, String> paramMap){
        if(paramMap == null){
            return;
        }
        String constant = getConfig("model_constant").trim();
        if(constant == null || "".equals(constant)){
            return;
        }
        //默认分隔符 param1:val1,param2:val2
        String[] paramArray = constant.split(",");
        for(String param : paramArray){
            String[] vals = param.split(":");
            paramMap.put("param_" + vals[0], vals[1]);
        }
    }
    
    public String getPackage(String key){
        return getConfig(key + "_package").trim();
    }
    
    //文件存在是否覆盖，默认覆盖，除非明确配置 override=false
    public boolean getOverride(String key){
        String override = getConfig(key + "_override").trim();
        if("false".equals(override)) {
        	return false;
        }
        return true;
    }
    
    public String getOutput(String key){
        return getConfig(key + "_output").trim();
    }
    
    public String getFilesuffix(String key){
        return getConfig(key + "_filesuffix").trim();
    }
    
    public String getOutPath(String outDir, String pkgName, String fileName){
        String outFileName = outDir;
        if(!outDir.endsWith(File.separator)){
            outFileName += File.separator;
        }
        outFileName += pkgName.replace('.', File.separatorChar);
        File file = new File(outFileName);
        if(!file.exists()){
            file.mkdirs();
        }
        if(!outFileName.endsWith(File.separator)){
            outFileName += File.separator;
        }
        outFileName += fileName;

        return outFileName;
    }
    
    /** 
     * @param tmpFile  模版文件名 
     * @param params   参数 
     * @param outFile  生成的静态文件路径(包含文件名称) 
     */  
    public void generate(String tmpFile, Map params, String outFile){
        String fullPath = null;
        String classPath = this.getClassPath();
        String templateConfig = getTemplateDir();
        if(classPath.endsWith(File.separator) && templateConfig.startsWith(File.separator)){
            fullPath = classPath + templateConfig.substring(1);
        }else if(!classPath.endsWith(File.separator) && !templateConfig.startsWith(File.separator)){
            fullPath = classPath + File.separator + templateConfig;
        }else{
            fullPath = classPath + templateConfig;
        }
        File templateDir = new File(fullPath);
        Writer out = null;
        try{
            Configuration cfg = new Configuration();
            cfg.setDirectoryForTemplateLoading(templateDir);
            cfg.setLocale(Locale.CHINA);
            cfg.setDefaultEncoding("utf-8");
            
            Template t = cfg.getTemplate(tmpFile);
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile),"utf-8"));
            t.process(params, out);
        }catch(IOException e){
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }finally{
            if (out != null) {  
                try {  
                    out.flush();  
                    out.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            } 
        }
    }   

    public void projectGenerate(){
    	String modelFile = getModelFile();
        Model model = null;
        if(modelFile.toLowerCase().endsWith(".pdm")){
           model =  PDMParser.parse(new File(modelFile), getModelPackage(), getModelExclude());
        }else if(modelFile.toLowerCase().endsWith(".cdm")){
           model =  CDMParser.parse(new File(modelFile), getModelPackage(), getModelExclude());
        }else{
            throw new RuntimeException("暂不支持的文件类型");
        }
        
        String outFile = null;
        Map params = new HashMap();
        addGlobalParam(params);

        List<Table> tables = model.getTables();
        params.put("tables", tables);

        for(Table table : tables){
            params.put("table", table);            
            String[] types = getGenerateType().split(",");
            for(String type : types){
            	//潜规则不要用！！！
//                if(table.getGroup() != null && !table.getGroup().equals("")){
//                    pkg = pkg + "." + table.getGroup();
//                }
            	String pkg = getPackage(type);
            	params.put("package", pkg);
            	params.put(type + "_package", pkg);
                outFile = getOutPath(getOutput(type), pkg, table.getCode() + getFilesuffix(type));
                //若配置为不覆盖
                if(this.getOverride(type) == false) {
                	File f = new File(outFile);
                	if(f.exists()) {
                		continue;
                	}
                }
                String template = type + ".ftl";
                generate(template, params, outFile);
            }            
            System.out.println("---------生成 ["+table.getName() + "(" + table.getCode() + ")] 代码结束----------");
        }
        System.out.println("---------生成成功，共生产[" + tables.size() + "]张表数据----------");
    }
    
    public static void main(String[] args) {
        CodeGenerator gen = new CodeGenerator();
        gen.projectGenerate();
    }
}
