public class TestMain {
    public static void main(String[] args) {



        Student s1 = new Student("C1010", "CatWoman", 3.5f);
        Student s2 = new Student("N207", "Batman", 3.4f);
        Student s3 = new Student("C2009", "PowerPuff", 3.9f);
        Student s4 = new Student("S221", "Superman", 3.9f);
        Student s5 = new Student("C2010", "CatWoman", 4.0f);
        Student[] ss = {s1, s2, s3, s4,s5};

        NaiveHashMap nHM = new NaiveHashMap(7);

        // insert
        for(Student s: ss) {

            boolean result = nHM.insert(HashCodeGenerator.generateHashCode(s.getName()), s);
            if(result)
                System.out.println(s.getName() + " is inserted without any trouble");
            else
                System.out.println(s.getName() + " cannot be inserted :(");

        }

        //print
        nHM.printHashMap();

        //search
        String testName = "CatWoman";

        Student x = nHM.lookup(HashCodeGenerator.generateHashCode(testName));

        if (x != null)
            System.out.println(x.getName() + " is found and their ID is " + x.getSID());
        else
            System.out.println(testName + " is not found in the system");

        testName = "PowerPuff";
        Student z = nHM.lookup(HashCodeGenerator.generateHashCode(testName));

        if (z != null)
            System.out.println(z.getName() + " is found and their ID is " + z.getSID());
        else
            System.out.println( testName + " is not found in the system");

    }

}
