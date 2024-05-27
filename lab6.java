public class StringBufferDemo {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("Hello");
        stringBuffer.append(" Acharya");
        System.out.println("After appending: " + stringBuffer);
        stringBuffer.insert(5, ", ");
        System.out.println("After inserting at index 5: " + stringBuffer);
        stringBuffer.delete(5, 7);
        System.out.println("After deleting characters from index 5 to 7: " + stringBuffer);
        stringBuffer.reverse();
        System.out.println("After reversing: " + stringBuffer);
        stringBuffer.replace(6, 11, "Java");
        System.out.println("After replacing from index 6 to 11 with 'Java': " + stringBuffer);
        System.out.println("Capacity of the buffer: " + stringBuffer.capacity());
        System.out.println("Length of the buffer: " + stringBuffer.length());
        stringBuffer.ensureCapacity(30);
        System.out.println("Capacity after ensuring: " + stringBuffer.capacity());
        stringBuffer.setLength(10);
        System.out.println("After setting length to 10: " + stringBuffer);
    }
}
