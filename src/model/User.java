package model;

public class User {
    private String username;
    private String password;
    private int saldo;

    // Constructor
    public User(String username, String password, int saldo) {
        this.username = username;
        this.saldo = saldo;
        this.password = password;
    }

    // getter setter
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        if (saldo > 0) {
            this.saldo = saldo;
        }else{
            System.out.println("Error. Saldo tidak boleh negatif");
        }
    }
}
