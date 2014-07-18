package com.sit.marketplace.params;

public class EucalyptusParams {

	private static EucalyptusParams instance = null;

	private static String DEFAULT_CLC_HOST = "10.14.99.97";
	private static int DEFAULT_CLC_PORT = 8773;
	private static String DEFAULT_AWS_ACCESS_KEY_ID = "4OFCOBFGPGVINNR7H6TMG";
	private static String DEFAULT_AWS_SECRET_KEY = "G0WewmHyE5KYaGcVWvSAQrsBsPnJb2qQOPIIc74h";
	private static String DEFAULT_EMI = "emi-89974121";
	private static String DEFAULT_SECURITY_GROUP = "default";	
	
	private String clcHost;
	private int clcPort;
	private String awsAccessKeyId;
	private String secretAccessKey;
	private String emi;
	private String securityGroup;
	
	public void setClcHost(String clcHost){
		this.clcHost = clcHost;
	}
	public String getClcHost(){
		return clcHost;
	}
	public void setClcPort(int clcPort){
		this.clcPort = clcPort;
	}
	public int getClcPort(){
		return clcPort;
	}
	public void setAwsAccessKeyId(String awsAccessKeyId){
		this.awsAccessKeyId = awsAccessKeyId;
	}
	public String getAwsAccessKeyId(){
		return awsAccessKeyId;
	}
	public void setSecretAccessKey(String secretAccessKey){
		this.secretAccessKey = secretAccessKey;
	}
	public String getSecretAccessKey(){
		return secretAccessKey;
	}
	public void setEmi(String emi){
		this.emi = emi;
	}
	public String getEmi(){
		return emi;
	}
	public void setSecurityGroup(String securityGroup){
		this.securityGroup = securityGroup;
	}
	public String getSecurityGroup(){
		return securityGroup;
	}
	public static EucalyptusParams getInstance() {
		if(instance == null) {
			instance = new EucalyptusParams();
			instance.setAwsAccessKeyId(DEFAULT_AWS_ACCESS_KEY_ID);
			instance.setClcHost(DEFAULT_CLC_HOST);
			instance.setClcPort(DEFAULT_CLC_PORT);
			instance.setEmi(DEFAULT_EMI);
			instance.setSecretAccessKey(DEFAULT_AWS_SECRET_KEY);
			instance.setSecurityGroup(DEFAULT_SECURITY_GROUP);
		}
		return instance;
	} 
}
