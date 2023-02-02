package dxc;
class Worker
{
	int employeeId;
	String employeeName;
	double salary;
	public Worker(int employeeId, String employeeName) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	 public String toString()
	 {
		 return "Employee\nemployeeId: "+this.getEmployeeId()+"\nemployeeName: "+this.getEmployeeName()+"\nsalary: "+this.getSalary();
				  }

	
}

class ContractEmployee extends Worker
{
	double wages;
	float hoursWorked;
	
	public ContractEmployee(int employeeId, String employeeName, double wages, float hoursWorked)
	{
		super(employeeId, employeeName);
		this.wages = wages;
		this.hoursWorked = hoursWorked;
	}
	
	void calculateSalary()
	{
		salary=hoursWorked*wages;
	}

	public double getWages() {
		return wages;
	}

	public void setWages(double wages) {
		this.wages = wages;
	}

	public float getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(float hoursWorked) {
		this.hoursWorked = hoursWorked;
	}
	
}

class PermanentEmployee extends Worker
{
	double basicPay;
	double hra;
	float experience;
	
	public PermanentEmployee(int employeeId, String employeeName, double basicPay, double hra, float experience)
	{
		super(employeeId, employeeName);
		this.basicPay = basicPay;
		this.hra = hra;
		this.experience = experience;
	}
	public double getBasicPay()
	{
		return basicPay;
	}
	public void setBasicPay(double basicPay) {
		this.basicPay = basicPay;
	}
	public double getHra() {
		return hra;
	}
	public void setHra(double hra) {
		this.hra = hra;
	}
	public float getExperience() {
		return experience;
	}
	public void setExperience(float experience) {
		this.experience = experience;
	}
	
	void calculateMonthlySalary()
	{
		double x=0;
		double variableComponent;
		if(getExperience()<3.0)
		{
			x=0;
		}
		else if(getExperience()>=3.0 && getExperience()<5.0)
		{
			x=5;
		}
		else if(getExperience()>=5.0 && getExperience()<10.0)
		{
			x=7;
		}
		else if(getExperience()>=10.0)
		{
			x=12;
		}
		variableComponent=getBasicPay()*(x/100);
		salary=getBasicPay()+getHra()+variableComponent;
		salary=Math.round(salary);
	}
	
	
}
public class Inheritance_Construction_Company {

	public static void main(String[] args) 
	{
		PermanentEmployee permanentEmployee = new PermanentEmployee(711211, "Rafael", 1855, 115, 3.5f);
		permanentEmployee.calculateMonthlySalary();
		System.out.println("Hi "+permanentEmployee.getEmployeeName()+", your salary is $"+permanentEmployee.getSalary());
				 
		ContractEmployee contractEmployee = new ContractEmployee(102, "Jennifer", 16, 90);
		contractEmployee.calculateSalary();
		System.out.println("Hi "+contractEmployee.getEmployeeName()+", your salary is $"+contractEmployee.getSalary());

	}

}
