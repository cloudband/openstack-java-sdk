package com.woorea.openstack.base.client;

public class OpenStackResponseException extends RuntimeException {

	private static final long serialVersionUID = 7294957362769575271L;

	protected String message;

	protected int status;
    
    protected Explanation explanation;

	public OpenStackResponseException(String message, int status) {
		this.message = message;
		this.status = status;
	}

    public OpenStackResponseException(String message, int status,Explanation explanation) {
        this.explanation=explanation;
        this.message = message;
        this.status = status;
    }


    public Explanation getExplanation() {
        return explanation;
    }

    public String getMessage() {
		return message;
	}

	public int getStatus() {
		return status;
	}

}
