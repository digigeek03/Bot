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
	
