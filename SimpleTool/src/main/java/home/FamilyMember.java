package home;

public class FamilyMember {
	String name;
	String age;
	String sex;
	String birthday;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String toString(){
		return "name:" + name+ ", sex: " + sex +", age: "+ age +", birthday: "+birthday+"\n";
	}
}
