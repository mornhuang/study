package com.huang.j2ee.ch02;

import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class BraveKnightTest {
    @BeforeClass
    public static void testBeforeClazzMethod() {
        System.out.println("呵呵，整个测试开始准备了");
    }

    @AfterClass
    public static void testAfterClazzMethod() {
        System.out.println("呀呀，整个测试结束了！");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("测试开始");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("测试结束");
    }

    @Test
    public void knightShouldEmbarkOnQuest() {
        Quest mockQuest = mock(Quest.class);

        BraveKnight knight = new BraveKnight(mockQuest);
        knight.embarkOnQuest();

        verify(mockQuest, times(1)).embark();
    }

    @Test
    public void aopKnightMinstrelTest() {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("com/huang/j2ee/ch02/knight.xml");

        Knight knight = (Knight)appContext.getBean("knight");
        knight.embarkOnQuest();
    }

    @Test
    public void testSPeL() throws Exception {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("com/huang/j2ee/ch02/knight.xml");

        Person person = (Person) appContext.getBean("person");
        person.showValue();
    }

    @Test
    public void testMagician() throws Exception {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("com/huang/j2ee/ch02/knight.xml");

        Magician magician = (Magician)appContext.getBean("magician");
        Thinker volunteer = (Thinker)appContext.getBean("volunteer");

        volunteer.thinkOfSomething("Queen of hearts");
        assertEquals("Queen of hearts", magician.getThoughts());

    }
}