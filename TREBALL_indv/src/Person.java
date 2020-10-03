
public class Person {

        public int LastID=0;// no se com fer que sigui general
        /*Atributs*/

        private String name;
        private int id;
        private int age;


        /* CONSTRUCTOR */

        public Person (String name, int age){
            this.name=name;
            this.id=LastID++;
            this.age= age;
        }

        @Override
        public String toString() {
            return "Person: " +
                    "id=" + id +
                    ", name='" + name + '\'';
        }

        public int getAge( ){
            return this.age;
        }

        public static void main(String[] args){
            Person p1 = new Person("Jaume",19);
            Person p2 = new Person("Abel",21);
            Person p3 = new Person("Javier",32);

            System.out.println(p1);
            System.out.println(p2);
            System.out.println(p3);

        }





    }

