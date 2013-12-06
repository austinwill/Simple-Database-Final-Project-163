

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class SimpleDatabaseTesting {

	@Test
	public void testToStringOneStudent() {
		SimpleDatabase list = new SimpleDatabase();
		Student stu1 = new Student("Randy Mandy","123",4.0);

		list.insert(stu1);
		assertEquals("Randy Mandy 123 4.0 " ,list.toString());
	}
	
	@Test
	public void testToStringTwoStudents() {
		SimpleDatabase list = new SimpleDatabase();
		Student stu1 = new Student("Randy Mandy","123",4.0);
		Student stu2 = new Student("Bubbles Katz","456",1.0);

		list.insert(stu1);
		list.insert(stu2);
		assertEquals("Randy Mandy 123 4.0 Bubbles Katz 456 1.0 "
				,list.toString());
	}
	
	@Test
	public void testToStringNoStudent() {
		SimpleDatabase list = new SimpleDatabase();
		
		assertEquals("" ,list.toString());
	}
	
	@Test
	public void testCompareToNotEqual() {
		SimpleDatabase list = new SimpleDatabase();
		Student what = new Student("STEW","123",4.0);
		Student who = new Student("LOOP","456",1.0);

		list.insert(who);
		list.insert(what);
		assertTrue(what.compareTo(who)==0);

	}

	@Test
	public void testCompareToEqual() {
		SimpleDatabase list = new SimpleDatabase();
		Student what = new Student("STEW","123",4.0);
		Student who = new Student("STEW","123",4.0);

		list.insert(who);
		list.insert(what);
		assertTrue(what.compareTo(who)==1);

	}
	
	@Test
	public void testStudentsGPA() {
		SimpleDatabase list = new SimpleDatabase();
		Student s1 = new Student("STEW","123",4.0);
		Student s2 = new Student("LOOP","456",4.0);

		list.insert(s1);
		list.insert(s2);
		assertTrue(s1.getGpa() == s2.getGpa());

	}

	@Test
	public void testStudentsGNum() {
		SimpleDatabase list = new SimpleDatabase();
		Student s1 = new Student("STEW","123",4.0);
		Student s2 = new Student("LOOP","123",4.0);

		list.insert(s1);
		list.insert(s2);
		assertEquals(s1.getGNumber(), s2.getGNumber());

	}
	
	@Test
	public void testStudentsName() {
		SimpleDatabase list = new SimpleDatabase();
		Student s1 = new Student("STEW","123",4.0);
		Student s2 = new Student("STEW","123",4.0);

		list.insert(s1);
		list.insert(s2);
		assertEquals(s1.getName(), s2.getName());

	}

	@Test (expected = IllegalArgumentException.class)
	public void testIncorrectGPA1() {
		SimpleDatabase list = new SimpleDatabase();
		Student stu1 = new Student ("Random Bobby","123",6.0);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testIncorrectGPA2() {
		SimpleDatabase list = new SimpleDatabase();
		Student stu1 = new Student ("Random Bobby","123",-1);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testIncorrectGPA3() {
		SimpleDatabase list = new SimpleDatabase();
		Student stu1 = new Student ("Random Bobby","123",0);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testIncorrectName1() {
		SimpleDatabase list = new SimpleDatabase();
		Student stu1 = new Student ("574","123",4.0);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testIncorrectName2() {
		SimpleDatabase list = new SimpleDatabase();
		Student stu1 = new Student ("","123",4.0);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testIncorrectGNumber1() {
		SimpleDatabase list = new SimpleDatabase();
		Student stu1 = new Student ("Random Bobby","sadly",4.0);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testIncorrectGNumber2() {
		SimpleDatabase list = new SimpleDatabase();
		Student stu1 = new Student ("Random Bobby","",4.0);
	}

	@Test
	public void testDeleteIncorrectGNumber() {
		SimpleDatabase list = new SimpleDatabase();
		Student stu1 = new Student("Randy Mandy","123",4.0);
		Student stu2 = new Student("Bubbles Katz","456",1.0);
		Student stu3 = new Student("Jewels McPools","789",2.0);
		list.insert(stu1);
		list.insert(stu2);
		list.insert(stu3);

		assertFalse(list.delete("999"));
	}


	@Test
	public void testInsertSimple() {
		SimpleDatabase list = new SimpleDatabase();
		Student stu1 = new Student("Randy Mandy","123",4.0);
		Student stu2 = new Student("Bubbles Katz","456",1.0);

		list.insert(stu1);
		list.insert(stu2);
		assertEquals("Randy Mandy 123 4.0 Bubbles Katz 456 1.0 "
				,list.toString());
	}

	@Test
	public void testInsertFromEmpty() {
		SimpleDatabase list = new SimpleDatabase();
		Student stu1 = new Student("Randy Mandy","123",4.0);
		list.insert(stu1);
		assertTrue(list.getCount()==1);
	}

	@Test
	public void testInsert10() {
		SimpleDatabase list = new SimpleDatabase();
		Student stu1 = new Student("Randy Mandy","123",4.0);
		for(int i=0;i<10;i++){
			list.insert(stu1);
		}
		assertTrue(list.getCount()==10);
	}
	@Test
	public void testInsert100() {
		SimpleDatabase list = new SimpleDatabase();
		Student stu1 = new Student("Randy Mandy","123",4.0);
		for(int i=0;i<100;i++){
			list.insert(stu1);
		}
		assertTrue(list.getCount()==100);
	}
	@Test
	public void testInsert1000() {
		SimpleDatabase list = new SimpleDatabase();
		Student stu1 = new Student("Randy Mandy","123",4.0);
		for(int i=0;i<1000;i++){
			list.insert(stu1);
		}
		assertTrue(list.getCount()==1000);
	}

	@Test
	public void testDeleteStudentSimple() {
		SimpleDatabase list = new SimpleDatabase();
		Student stu1 = new Student("Randy Mandy","123",4.0);
		Student stu2 = new Student("Bubbles Katz","456",1.0);
		Student stu3 = new Student("Jewels McPools","789",2.0);
		list.insert(stu1);
		list.insert(stu2);
		list.insert(stu3);
		list.delete("789");
		assertEquals("Randy Mandy 123 4.0 Bubbles Katz 456 1.0 "
				,list.toString());

	}

	@Test
	public void testDeleteAll() {
		SimpleDatabase list = new SimpleDatabase();
		Student stu1 = new Student("Randy Mandy","123",4.0);
		Student stu2 = new Student("Bubbles Katz","456",1.0);
		Student stu3 = new Student("Jewels McPools","789",2.0);
		list.insert(stu1);
		list.insert(stu2);
		list.insert(stu3);
		list.delete("123");
		list.delete("456");
		list.delete("789");
		assertEquals("",list.toString());
	}
	@Test
	public void testDelete10(){
		SimpleDatabase list = new SimpleDatabase();
		Student stu1 = new Student("Randy Mandy","123",4.0);
		for(int i=0;i<10;i++){
			list.insert(stu1);

			for(int r=0;r<10;r++){
				list.delete("123");
			}
			assertTrue(list.getCount()==0);
		}
	}
	@Test
	public void testDelete100(){
		SimpleDatabase list = new SimpleDatabase();
		Student stu1 = new Student("Randy Mandy","123",4.0);
		for(int i=0;i<100;i++){
			list.insert(stu1);

			for(int r=0;r<100;r++){
				list.delete("123");
			}
			assertTrue(list.getCount()==0);
		}
	}
	@Test
	public void testDelete1000(){
		SimpleDatabase list = new SimpleDatabase();
		Student stu1 = new Student("Randy Mandy","123",4.0);
		for(int i=0;i<1000;i++){
			list.insert(stu1);


		}

		for(int r=0;r<1000;r++){
			list.delete("123");
		}
		assertTrue(list.getCount()==0);
	}

	@Test 
	public void testDeleteFirstItem(){
		SimpleDatabase list = new SimpleDatabase();
		Student stu1 = new Student ("Randy Mandy","123",4.0);
		list.insert(stu1);
		list.delete("123");
		assertTrue(list.getCount()==0);
	}

	@Test 
	public void testDeleteNotFound(){
		SimpleDatabase list = new SimpleDatabase();
		Student stu1 = new Student("Randy Mandy","456",4.0);
		assertFalse(list.delete("123"));
	}


	@Test
	public void testFindTop() {
		SimpleDatabase list = new SimpleDatabase();
		Student stu1 = new Student("Randy Mandy","123",4.0);
		Student stu2 = new Student("Bubbles Katz","456",1.0);
		Student stu3 = new Student("Jewels McPools","789",2.0);
		list.insert(stu1);
		list.insert(stu2);
		list.insert(stu3);
		assertEquals("Jewels McPools 789 2.0 ",list.find("789")
				.toString());
	}

	@Test
	public void testFindMiddle() {
		SimpleDatabase list = new SimpleDatabase();
		Student stu1 = new Student("Randy Mandy","123",4.0);
		Student stu2 = new Student("Bubbles Katz","456",1.0);
		Student stu3 = new Student("Jewels McPools","789",2.0);
		list.insert(stu1);
		list.insert(stu2);
		list.insert(stu3);
		assertEquals("Bubbles Katz 456 1.0 ",list.find("456")
				.toString());
	}

	@Test
	public void testFindTail() {
		SimpleDatabase list = new SimpleDatabase();
		Student stu1 = new Student("Randy Mandy","123",4.0);
		Student stu2 = new Student("Bubbles Katz","456",1.0);
		Student stu3 = new Student("Jewels McPools","789",2.0);
		list.insert(stu1);
		list.insert(stu2);
		list.insert(stu3);
		assertEquals("Randy Mandy 123 4.0 ",list.find("123")
				.toString());
	}

	@Test
	public void testFindNotFound() {
		SimpleDatabase list = new SimpleDatabase();
		Student stu1 = new Student("Randy Mandy","123",4.0);
		Student stu2 = new Student("Bubbles Katz","456",1.0);
		Student stu3 = new Student("Jewels McPools","789",2.0);
		list.insert(stu1);
		list.insert(stu2);
		list.insert(stu3);
		assertEquals(null ,list.find("999"));
	}


	@Test
	public void testRemoveDuplicatesSimple() {
		SimpleDatabase list = new SimpleDatabase();
		Student stu1 = new Student("Randy Mandy","123",4.0);
		Student stu2 = new Student("Bubbles Katz","456",1.0);
		Student stu3 = new Student("Jewels McPools","789",2.0);
		Student stu4 = new Student("Jewels McPools","789",2.0);
		list.insert(stu1);
		list.insert(stu2);
		list.insert(stu3);
		list.insert(stu4);
		list.removeDuplicates();
		assertEquals("Randy Mandy 123 4.0 Bubbles Katz 456 1.0 " +
				"Jewels McPools 789 2.0 ",list.toString());
	}

	@Test
	public void testRemoveDuplicatesMultiple() {
		SimpleDatabase list = new SimpleDatabase();
		Student stu1 = new Student("Randy Mandy","123",4.0);
		Student stu5 = new Student("Randy Mandy","123",4.0);
		Student stu6 = new Student("Randy Mandy","123",4.0);
		Student stu2 = new Student("Bubbles Katz","456",1.0);
		Student stu7 = new Student("Bubbles Katz","456",1.0);
		Student stu8 = new Student("Bubbles Katz","456",1.0);
		Student stu3 = new Student("Jewels McPools","789",2.0);
		Student stu4 = new Student("Jewels McPools","789",2.0);
		list.insert(stu1);
		list.insert(stu5);
		list.insert(stu6);
		list.insert(stu2);
		list.insert(stu7);
		list.insert(stu8);
		list.insert(stu3);
		list.insert(stu4);

		list.removeDuplicates();
		assertEquals("Randy Mandy 123 4.0 Bubbles Katz 456 1.0 " +
				"Jewels McPools 789 2.0 ",list.toString());
	}

	@Test
	public void testRemoveDuplicates1000() {
		SimpleDatabase list = new SimpleDatabase();
		Student stu1 = new Student("Randy Mandy","123",4.0);
		for(int i=0;i<1000;i++){
			list.insert(stu1);
		}
		list.removeDuplicates();
		assertEquals("Randy Mandy 123 4.0 ",list.toString());
	}

	@Test
	public void testRemoveDuplicatesNone() {
		SimpleDatabase list = new SimpleDatabase();
		Student stu1 = new Student("Randy Mandy","123",4.0);
		Student stu2 = new Student("Bubbles Katz","456",1.0);
		Student stu3 = new Student("Jewels McPools","789",2.0);
		list.insert(stu1);
		list.insert(stu2);
		list.insert(stu3);
		list.removeDuplicates();
		assertEquals("Randy Mandy 123 4.0 Bubbles Katz 456 1.0 " +
				"Jewels McPools 789 2.0 ",list.toString());
	}
	@Test
	public void testSaveAndLoad(){
		SimpleDatabase list = new SimpleDatabase();
		Student stu1 = new Student("Randy Mandy","123",4.0);
		Student stu2 = new Student("Bubbles Katz","456",1.0);
		Student stu3 = new Student("Jewels McPools","789",2.0);
		list.insert(stu1);
		list.insert(stu2);
		list.insert(stu3);
		list.saveDB("test");
		list.delete("123");
		list.delete("456");
		list.delete("789");
		list = list.loadDB("test");
		assertEquals("Randy Mandy 123 4.0 Bubbles Katz 456 1.0 " +
				"Jewels McPools 789 2.0 ",list.toString());
	}
	@Test
	public void testSaveAndLoad2(){
		SimpleDatabase d1 = new SimpleDatabase();
		SimpleDatabase d2 = new SimpleDatabase();
		Student stu1 = new Student("Randy Mandy","123",4.0);
		d1.insert(stu1);
		d1.saveDB("test2");
		d2 = d2.loadDB("test2");
		assertEquals(d1.toString(), d2.toString());
	}

	@Test
	public void testSaveAndLoad3(){
		SimpleDatabase d1 = new SimpleDatabase();
		SimpleDatabase d2 = new SimpleDatabase();
		d1.saveDB("test3");
		d2 = d2.loadDB("test3");
		assertEquals(d1.toString(), d2.toString());
	}

	@Test
	public void testReverseOne() {
		SimpleDatabase list = new SimpleDatabase();
		Student stu1 = new Student("Randy Mandy","123",4.0);
		list.insert(stu1);
		list.reverseList();
		assertEquals("Randy Mandy 123 4.0 ",list.toString());
	}

	@Test
	public void testReverseShort() {
		SimpleDatabase list = new SimpleDatabase();
		Student stu1 = new Student("Randy Mandy","123",4.0);
		Student stu2 = new Student("Bubbles Katz","456",1.0);
		list.insert(stu1);
		list.insert(stu2);
		list.reverseList();
		assertEquals("Bubbles Katz 456 1.0 Randy Mandy 123 4.0 "
				,list.toString());
	}

	@Test
	public void testReverseLong() {
		SimpleDatabase list = new SimpleDatabase();
		Student stu1 = new Student("Randy Mandy","123",4.0);
		Student stu2 = new Student("Bubbles Katz","456",1.0);
		Student stu3 = new Student("Wow Name","636",2.4);
		Student stu4 = new Student("Party Animal","111",1.0);
		Student stu5 = new Student("Not Animal","222",4.0);
		list.insert(stu1);
		list.insert(stu2);
		list.insert(stu3);
		list.insert(stu4);
		list.insert(stu5);
		list.reverseList();
		assertEquals("Not Animal 222 4.0 Party Animal 111 1.0 Wow Name" +
				" 636 2.4 Bubbles Katz 456 1.0 Randy Mandy 123 4.0 "
				,list.toString());
	}

	@Test
	public void testClear() {
		SimpleDatabase list = new SimpleDatabase();
		SimpleDatabase list2 = new SimpleDatabase();
		Student stu1 = new Student("Randy Mandy","123",4.0);
		Student stu2 = new Student("Bubbles Katz","456",1.0);
		Student stu3 = new Student("Wow Name","636",2.4);
		Student stu4 = new Student("Party Animal","111",1.0);
		Student stu5 = new Student("Not Animal","222",4.0);
		list.insert(stu1);
		list.insert(stu2);
		list.insert(stu3);
		list.insert(stu4);
		list.insert(stu5);
		list.reverseList();
		assertEquals("Not Animal 222 4.0 Party Animal 111 1.0 Wow Name" +
				" 636 2.4 Bubbles Katz 456 1.0 Randy Mandy 123 4.0 "
				,list.toString());
	}



}
