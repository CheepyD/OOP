package ua.khpi.oop.hulevych13;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Agency implements Externalizable{
	private String firmName;
    private String position;
    private String circs;
    private int salary;
    private boolean key;
    private Requierments reqs;

    public Agency() {
    	
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
	
	public void setFirmName(String temp) {
        this.firmName = temp;
    }

    public void setPosition(String temp) {
        this.position = temp;
    }

    public void setCircs(String temp) {
        this.circs = temp;
    }

	public void setSalary(int temp) {
		this.salary = temp;
	}
	
	public void setKey(boolean temp) {
		this.key = temp;
	}
	
	public Requierments getReqs() {
		return reqs;
	}	
	public void setReqs(Requierments reqss) {
		 this.reqs = reqss;
	}
	public void isNeedRequierments(int exp, String education_) {
		
		if(this.key == true) {
			reqs = new Requierments();
			reqs.setYexp(exp);
			reqs.setEducation(education_);
		}
		else return;
	}
	
	static public class Requierments implements Externalizable{
		private static final long serialVersionUID = 1L;
		private Integer yexp;
		private String education;
		
		public Requierments(){
		
		}
		
		public Integer getYexp() {
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

		@Override
		public void writeExternal(ObjectOutput out) throws IOException {
			out.writeObject(this.getYexp());
			out.writeObject(this.getEducation());
		}

		@Override
		public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
			this.yexp = (int)in.readObject();
			this.education = (String) in.readObject();
		}
		}
	

	public void print() {
		System.out.println("Информация об этой фирме:");
		System.out.printf("Название фирмы : %s \nДолжность : %s \nУсловия работы: %s \nЗарплата : %d \n", this.firmName, this.position, this.circs, this.salary);
		System.out.println("Дополнительные требования: ");
		if(this.key) { this.reqs.print();}
		else { System.out.printf("Без опыта работы \nОбычное образование \n");
		}
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(this.getFirmName());
		out.writeObject(this.getPosition());
		out.writeObject(this.getCircs());
		out.writeInt(this.getSalary());
		out.writeBoolean(this.getKey());
		if(this.getKey() == true) out.writeObject(this.getReqs());
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		this.firmName = (String) in.readObject();
		this.position = (String) in.readObject();
		this.circs = (String) 	 in.readObject();
		this.salary = in.readInt();
		this.key = in.readBoolean();
		if(this.getKey() == true) this.reqs = (Requierments) in.readObject();
	}
}



