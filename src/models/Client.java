package models;

public class Client {

        private static int nextId = 1;
        private int clientId;

        private String name;

        private String lastName;

        private String email;

        private String phone;

        public Client(){
            this.clientId = nextId;
            nextId++;
        }

        public Client(String name, String lastName, String email, String phone){
            this.name = name;
            this.lastName = lastName;
            this.email = email;
            this.phone = phone;
            this.clientId = nextId;
            nextId++;
        }

        public static int getNextId() {
            return nextId;
        }

        public static void setNextId(int nextId) {
            Client.nextId = nextId;
        }

        public int getClientId() {
            return clientId;
        }

        public void setClientId(int clientId) {
            this.clientId = clientId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        @Override
        public String toString(){
            return name + " " + lastName + " " + email + " " + phone;
        }

}
