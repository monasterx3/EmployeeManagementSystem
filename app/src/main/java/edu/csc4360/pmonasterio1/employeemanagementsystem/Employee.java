package edu.csc4360.pmonasterio1.employeemanagementsystem;

public class Employee {
    Integer id;
    String name, position, email, phoneno;
    String salary;
    int image;

    public Employee(int image, Integer id, String name, String position, String email, String phoneno, String salary) {
        this.image = image;
        this.id = id;
        this.name = name;
        this.position = position;
        this.email = email;
        this.phoneno = phoneno;
        this.salary = salary;

    }
    public Employee(){

    }
        public Integer getId () {
            return id;
        }

        public void setId () {
         this.id = id;
        }

        public int getImage () {
            return image;
        }
        public void setImage(int image){
            this.image = image;
        }

        public String getName () {
            return name;
        }

        public void setName(String toString) {
            this.name = name;
        }

        public String getPosition () {
            return position;
        }

        public void setPosition(String toString) {
        this.position = position;
        }

        public String getEmail () {
            return email;
        }

        public void setEmail(String toString) {
            this.email = email;
        }

        public String getPhone () {
            return phoneno;
        }

        public void setPhoneno(String toString) {
            this.phoneno = phoneno;
    }

        public String getSalary () {
            return salary;
        }

        public void setSalary(String toString) {
        this.salary = salary;
        }

}
