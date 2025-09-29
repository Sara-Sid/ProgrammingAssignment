public interface OurHashMap<U extends Comparable, T extends Comparable>{


    @Override
    public boolean delete(Integer key) {

        if (key == null) return false;

        int index = this.hashFunction(key);

        if (index < 0 || index >= tableSize) return false;

        if(hashTable[index] != null)
        {
            hashTable[index] = null;
            System.out.println("Successfully deleted item at index " + index + " for key " + key);
            return true;
        }
        else {
            System.out.println("No item found at index " + index + " for key " + key + ". Deletion skipped.");
            return false;
        }
    }



    @Override
    public Integer getHashCode(Student s) {

        return HashCodeGenerator.generateHashCode(s.getName());
    }


    @Override
    public int hashFunction(Integer key) {

        return Math.abs(key % tableSize);
    }


    @Override
    public void printHashMap() {

        System.out.println("\n*** Printing the current NaiveHashMap (Size: " + tableSize + ") ***");
        for(int i = 0; i < tableSize; i++)
        {
            String content = (hashTable[i] == null) ? "---" : hashTable[i].getName() + " (Key: " + getHashCode(hashTable[i]) + ")";
            System.out.println(i + " >> " + content);

        }
        System.out.println("*** End of NaiveHashMap ***\n");
    }
}
