package parkingsystem;

import java.util.HashMap;

public class AdminLogin {
    private HashMap<String, String> karyawan;

    public AdminLogin() {
        karyawan = new HashMap<>();
        karyawan.put("K1", "001");
        karyawan.put("K2", "002");
        karyawan.put("K3", "003");
    }

    public boolean login(String username, String password) {
        return karyawan.containsKey(username) && karyawan.get(username).equals(password);
    }
}
