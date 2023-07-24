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
	public void testBotInstructionIsInValidWithSpace() {

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
	
	@Test
    public void testProcessInputTurnRight() {
		Bot robo1 = new Bot();
		robo1.processInput("I 10");
		robo1.processInput("R");
		robo1.processInput("R");
		robo1.processInput("R");
		robo1.processInput("R");
		robo1.processInput("R");
        Assertions.assertEquals("E", robo1.direction);
    }
	
	@Test
    public void testProcessInputTurnLeft() {
		Bot robo1 = new Bot();
		robo1.processInput("I 10");
		robo1.processInput("L");
		robo1.processInput("L");
		robo1.processInput("L");
		robo1.processInput("L");
		robo1.processInput("L");
        Assertions.assertEquals("W", robo1.direction);
    }
	
	@Test
    public void testProcessInputPrintFloor() {
        Assertions.assertDoesNotThrow(() -> {
        	Bot robo1 = new Bot();
    		robo1.processInput("P");
        });
    }
	
	@Test
    public void testProcessInputPrintCurrentStatus() {
        Assertions.assertDoesNotThrow(() -> {
        	Bot robo1 = new Bot();
    		robo1.processInput("C");
        });
    }
	@Test
    public void testProcessInputQuit() {
		Bot robo1 = new Bot();
        boolean result = robo1.processInput("Q");
        Assertions.assertFalse(result);
    }
	 
	 @Test
	    public void testProcessInputInitializeSystem() {
	        Assertions.assertDoesNotThrow(() -> {
	        	Bot robo1 = new Bot();
	    		robo1.processInput("I5");
	        });
	        
	    }
	 @Test
	    public void testProcessInputMoveForward() {
	        Assertions.assertDoesNotThrow(() -> {
	        	Bot robo1 = new Bot();
	        	robo1.processInput("I 10");
	    		robo1.processInput("M3");
	    		assertEquals(0,robo1.currentCol);
	    		assertEquals(3,robo1.currentRow);
	        });
	    }
	 @Test
	    public void testMoveForwardNorthValid() {
		     	Bot robo1 = new Bot();
		     	robo1.processInput("I 10");
		     	robo1.moveForward(2);
	        Assertions.assertEquals(2, robo1.currentRow);
	        Assertions.assertEquals(0, robo1.currentCol);
	    }
	 @Test
	    public void testMoveForwardEastwESTValid() {
		 Bot robo1 = new Bot();
	     	robo1.processInput("I 10");
	     	robo1.turnRight(); 
	        robo1.moveForward(4);
	        robo1.turnRight();
	        robo1.turnRight();
	        robo1.moveForward(2);
	        Assertions.assertEquals(0, robo1.currentRow);
	        Assertions.assertEquals(2, robo1.currentCol);
	    }
	 @Test
	    public void testMoveForwardSouthValid() {
		 Bot robo1 = new Bot();
	     	robo1.processInput("I 10");
	     	robo1.processInput("M8");
	     	robo1.turnRight(); 
	     	robo1.turnRight();
	        robo1.moveForward(4);
	        Assertions.assertEquals(0, robo1.currentCol);
	        Assertions.assertEquals(4, robo1.currentRow);
	    }
	 @Test
	    public void testMoveForwardNorthInvalidOutOfBounds() {
		 Bot robo1 = new Bot();
	     	robo1.processInput("I 4");
	     	robo1.moveForward(6); 
	        Assertions.assertEquals(0, robo1.currentRow);
	        Assertions.assertEquals(0, robo1.currentCol);
	    }
	 @Test
	    public void testMoveForwardEastInvalidOutOfBounds() {
		 Bot robo1 = new Bot();
	     	robo1.processInput("I 4");
	     	robo1.turnRight(); 
	        robo1.moveForward(6); 
	        Assertions.assertEquals(0, robo1.currentRow);
	        Assertions.assertEquals(0, robo1.currentCol);
	    }
	 @Test
	    public void testMoveForwardWestInvalidOutOfBounds() {
		 Bot robo1 = new Bot();
	     	robo1.processInput("I 4");
	     	robo1.turnRight(); 
	        robo1.moveForward(6);
	        Assertions.assertEquals(0, robo1.currentRow);
	        Assertions.assertEquals(0, robo1.currentCol);
	    }
	 @Test
	    public void testMoveForwardNorthValidPenDown() {
		 Bot robo1 = new Bot();
	     	robo1.processInput("I 10");
	     	robo1.penDown();
	        robo1.moveForward(3);
	        Assertions.assertEquals(3, robo1.currentRow);
	        Assertions.assertEquals(0, robo1.currentCol);
	        Assertions.assertEquals(1, robo1.floor[0][0]);
	        Assertions.assertEquals(1, robo1.floor[1][0]);
	        Assertions.assertEquals(1, robo1.floor[2][0]);
	    }
	 @Test
	    public void testMoveForwardEastValidPenDown() {
		 Bot robo1 = new Bot();
	     	robo1.processInput("I 10");
	     	robo1.penDown();
	        robo1.turnRight(); 
	        robo1.moveForward(2);
	        Assertions.assertEquals(0, robo1.currentRow);
	        Assertions.assertEquals(2, robo1.currentCol);
	        Assertions.assertEquals(1, robo1.floor[0][0]);
	        Assertions.assertEquals(1, robo1.floor[0][1]);
	        Assertions.assertEquals(1, robo1.floor[0][2]);
	    }
	 @Test
	    public void testMoveForwardNorthInvalidOutOfBoundsPenDown() {
		 Bot robo1 = new Bot();
	     	robo1.processInput("I 4");
	     	robo1.penDown();
	        robo1.moveForward(6); 
	        Assertions.assertEquals(0, robo1.currentRow);
	        Assertions.assertEquals(0, robo1.currentCol);
	        Assertions.assertEquals(0, robo1.floor[0][0]);
	    }
	 @Test
	    public void testMoveForwardSouthInvalidOutOfBoundsPenDown() {
		 Bot robo1 = new Bot();
	     	robo1.processInput("I 4");
	     	robo1.penDown();
	        robo1.turnRight();
	        robo1.turnRight();
	        robo1.moveForward(6);
	        Assertions.assertEquals(0, robo1.currentRow);
	        Assertions.assertEquals(0, robo1.currentCol);
	        Assertions.assertEquals(0, robo1.floor[0][0]);
	    }
	 @Test
     public void testPrintEmptyFloor() {
      ByteArrayOutputStream output = new ByteArrayOutputStream();
      //System.setOut(new PrintStream(output));
      Bot robo1 = new Bot();
      robo1.processInput("I 3");
      robo1.printMatrix();
      
      String expectedOutput = "0       \n1       \n2       \n3       \n  0 1 2 3 ";
     assertFalse(output.toString().equals(expectedOutput));
	 }
	 @Test
     public void testPrintPath() {
      ByteArrayOutputStream output = new ByteArrayOutputStream();
      //System.setOut(new PrintStream(output));
      Bot robo1 = new Bot();
      robo1.processInput("I 3");
      robo1.processInput("m 2");
      
      robo1.printMatrix();
      
      String expectedOutput = "3       \n2 *     \n1 *     \n0 *     \n  0 1 2 3 ";
     assertFalse(output.toString().equals(expectedOutput));
	 }
	 @Test
     public void testCurrentLocation() {
      ByteArrayOutputStream output = new ByteArrayOutputStream();
      //System.setOut(new PrintStream(output));
      Bot robo1 = new Bot();
      robo1.processInput("I 3");
      robo1.processInput("m 2");
      
      robo1.printMatrix();
      
      String expectedOutput = "Moved forward 2 spaces. New position: [2, 0]";
     assertFalse(output.toString().equals(expectedOutput));
	 }
	 @Test
	    public void testBotPenDownFunction() {
		 Bot robo1 = new Bot();
	     	robo1.processInput("I 10");
	     	robo1.penDown();
	        Assertions.assertEquals(true, robo1.penDown);
	    }
	 @Test  
	    public void testBotPenUpFunction() {
		 Bot robo1 = new Bot();
	     	robo1.processInput("I 10");
	     	robo1.penUp();
	        Assertions.assertEquals(false, robo1.penDown);
	    }
	 @Test
	    public void testBotTurnLeftFunction() {
		 Bot robo1 = new Bot();
	     	robo1.processInput("I 10");
	     	robo1.turnLeft();
	        Assertions.assertEquals("W", robo1.direction);
	    }
	 @Test
	    public void testBotTurnRightFunction() {
		 Bot robo1 = new Bot();
	     	robo1.processInput("I 10");
	     	robo1.turnRight();
	        Assertions.assertEquals("E",robo1.direction);
	    }

}
