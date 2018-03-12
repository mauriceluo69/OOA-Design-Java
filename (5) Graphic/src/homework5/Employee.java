package homework5;

public abstract class Employee
{
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;

    public Employee()
    {
    }

    public Employee(String _first, String _last, String _social)
    {
        this.firstName = _first;
        this.lastName = _last;
        this.socialSecurityNumber = _social;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSocialSecurityNumber()
    {
        return socialSecurityNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    abstract double earning();

}
