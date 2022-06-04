public class Main {
    public static void main(String[] args) {
        Login login = new Login();
        modelLogin model = new modelLogin();
        controllerLogin con = new controllerLogin(login, model);
    }
}
