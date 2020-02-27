package cz.cellar.fakeid.retrofit;

class FakeId {

    private String name;
    private String surname;
    private String gender;
    private String region;
    private String phone;
    private Birthday birthday;
    private String email;
    private String photo;

    private static class Birthday {
        private String dmy;
    }
}
