package testbot;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import bot.Bot;

public class TestBot {
	@Test
	public void testBotInstructionIsValidwithoutSpace() {

		IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, new Executable() {

			@Override
			public void execute() throws Throwable {
				Bot robo1 = new Bot();
				robo1.processInput(" ");
			}
		}, "Blank space is invalid command");
		Assertions.assertEquals("Blank space is invalid command", thrown.getMessage());
	}

	@Test
	public void testBotInstructionIsEmpty() {

		IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, new Executable() {

			@Override
			public void execute() throws Throwable {
				Bot robo1 = new Bot();
				robo1.processInput("");
			}
		}, "Enter valid command");
		Assertions.assertEquals("Enter valid command", thrown.getMessage());
	}

		@Test
	public void testBotInstructionIsNull() {

		NullPointerException thrown = Assertions.assertThrows(NullPointerException.class, new Executable() {

			@Override
			public void execute() throws Throwable {
				Bot robo1 = new Bot();
				robo1.processInput(null);
			}
		}, "null command is invalid");
		Assertions.assertEquals("null command is invalid", thrown.getMessage());
	}

	@Test
	public void testInvalidBotInstruction() {

		IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, new Executable() {

			@Override
			public void execute() throws Throwable {
				Bot robo1 = new Bot();
				robo1.processInput("z");
			}
		}, "Entered command is invalid");
		Assertions.assertEquals("Entered command is invalid", thrown.getMessage());
	}
	//	 @Test
//	    public void testInvalidBotSteps() {
//	         
//	    	IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
//	             
//	            @Override
//	            public void execute() throws Throwable {
//	                Bot robo1 = new Bot();
//	                robo1.processInput("I 10");
//	                robo1.processInput("M 0");
//	            }
//	        }, "Invalid steps! Please enter positive value")
//	    	assertNotEquals("Invalid steps! Please enter positive value", thrown.getMessage());
//	    }
	
	@Test
	 public void testProcessInputPenUp() {
		
		Bot robo1 = new Bot();
		robo1.processInput("U");
        Assertions.assertFalse(robo1.penDown);
    }
		@Test
    public void testProcessInputPenDown() {
		Bot robo1 = new Bot();
		robo1.processInput("D");
        Assertions.assertTrue(robo1.penDown);
    }
	
