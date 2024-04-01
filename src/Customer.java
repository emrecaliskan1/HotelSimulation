public class Customer{

    private String name;
    private String surname;
    private int age;
    private String job;

    public Customer(){
    }

    public Customer(String name, String surname, int age , String job){
        this.name=name;
        this.surname=surname;
        this.age = age;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void Display() {
        System.out.println("Name: " + name + " Surname: " +surname + " age: " + age + "job: " + job);
    }
}
