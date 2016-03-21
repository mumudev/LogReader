package ALogReaderInConsole;

public class Main {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		String hostname	 = "192.168.1.177";
		String username	 = "ycl";
		String password	 = "231";
		String commond	 = "tail -f ";
		String address	 = "/home/ycl/tomcat/";
		String execLine  = commond + address + "8080-tomcat8/logs/info.html";
		String execLine0 = commond + address + "8080-tomcat8/logs/info.log";
		String execLine1 = commond + address + "8188-tomcat8/logs/info.log";
		String execLine2 = commond + address + "8288-tomcat8/logs/info.log";
		String execLine3 = commond + address + "8388-tomcat8/logs/info.log";
		String execLine4 = "bash /home/apache/tomcat-startup.sh";
		Basic b = new Basic();
		b.executor(hostname, username, password, execLine);
	}
}
