ʹ��jdk�Դ���keytool����:
keytool -genkey -alias jwt -keyalg  RSA -keysize 1024 -validity 365 -keystore jwt.jks
ʹ��keytool������Կ������Ϊjwt���㷨ΪRSA����Ч��Ϊ365�죬�ļ���Ϊjwt.jks,�ļ������ڵ�ǰ��cmd��·����
����ʾ��������,����oversky,���µ�������Ժ���,�س�pass


ʹ��openssl��ʽ
���ɼ��ܳ���1024λ��Կ

����Կ�ɷ�Ϊ1024��2048��4096��λ��Կ��λ����ͬ���ɼӽ������ĳ��Ȳ�һ��
 ����1024λ��Կ�� �ɼӽ������ĳ��� len = 1024/8 - 11 = 117�ֽ�

����˽Կ��openssl genrsa -out rsa_private_key.pem 1024


���ɹ�Կ��openssl rsa -in rsa_private_key.pem -out rsa_public_key.pem -pubout


����ʹ�õ�RSA�ļ�����Ҫ����PKCS#8�����,֮ǰ���ɵ�RSA�ļ�ֻ���������ɹ�Կ�ļ���
��������Ҫ��֮ǰ��˽Կ�ļ�����PKCS#8���룬����һ��������˽Կ�ļ�

ת����ʽ��openssl pkcs8 -topk8 -in rsa_private_key.pem -out pkcs8_rsa_private_key.pem -nocrypt
