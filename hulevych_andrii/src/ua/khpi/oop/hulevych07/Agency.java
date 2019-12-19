package ua.khpi.oop.hulevych07;

interface Printable {
	void print();
}

public class Agency{
    private String firmName;
    private String position;
    private String circs;
    private int salary;
    private boolean key;
    Requierments reqs;

    public Agency(String firmName, String position, String circs,int sal, boolean key) {
        this.firmName = firmName;
        this.position = position;
        this.circs = circs;
        this.salary = sal;
        this.key = key;
    }

    public String getFirmName() {
        return firmName;
    }

    public String getPosition() {
        return position;
    }

    public String getCircs() {
        return circs;
    }

	public int getSalary() {
		return salary;
	}
	
	public boolean getKey() {
		return key;
	}
	
	
	public class Requierments{
		private int yexp;
		private String education;
		public int getYexp() {
			return yexp;
		}
		public void setYexp(int yexp) {
			this.yexp = yexp;
		}
		public String getEducation() {
			return education;
		}
		public void setEducation(String education) {
			this.education = education;
		}
		public void print() {
			System.out.printf("Опыт работы :  %d \n Образование : %s", this.yexp, this.education);
			System.out.println("");
		}
		}
	
	public void isNeedRequierments(int exp, String education_) {
		if(this.key == true) {
			reqs = new Requierments();
			reqs.setYexp(exp);
			reqs.setEducation(education_);
		}
		else return;
	}

	public void print() {
		System.out.println("Информация об этой должности:");
		System.out.printf("Название фирмы : %s \nДолжность : %s \nУсловия работы: %s \nЗарплата : %d \n", this.firmName, this.position, this.circs, this.salary);
		System.out.println("Требование следующие: ");
		if(this.key) { this.reqs.print();}
		else { System.out.printf("Без опыта работы \nСреднее образование \n");
		}
	}
}