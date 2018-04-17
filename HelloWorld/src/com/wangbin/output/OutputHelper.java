package com.wangbin.output;

/**
 * 
 * @author wangbin
 *
 */
public class OutputHelper {

	private IOutputGenerator outputGenerator;
	
	public void setOutputGenerator(IOutputGenerator outputGenerator) {
		this.outputGenerator = outputGenerator;
	}
	
	public void outputStr(){
		this.outputGenerator.output();
	}
}
