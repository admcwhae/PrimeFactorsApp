/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.event.KeyEvent;
import org.assertj.swing.annotation.GUITest;
import org.assertj.swing.core.KeyPressInfo;
import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JButtonFixture;
import org.assertj.swing.fixture.JLabelFixture;
import org.assertj.swing.fixture.JTextComponentFixture;
import org.assertj.swing.junit.runner.GUITestRunner;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import prime.PrimeFactorFinder;

/**
 *
 * @author Alex McWhae
 */
@RunWith(GUITestRunner.class)
public class Prime_GUITest {

    private FrameFixture window;

    private JTextComponentFixture inputFieldFixture;

    private JLabelFixture inputMsgLabelFixture;

    private JButtonFixture calculateButtonFixture;
    private JButtonFixture resetButtonFixture;


    private JTextComponentFixture isPrimeFieldFixture;
    private JTextComponentFixture primeFactorsFieldFixture;

    public Prime_GUITest() {
    }

    @BeforeClass
    public static void setUpClass() {
        FailOnThreadViolationRepaintManager.install();
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        Prime_GUI frame = GuiActionRunner.execute(() -> new Prime_GUI());

        window = new FrameFixture(frame);
        window.show();         // shows the frame to test

        inputFieldFixture = window.textBox(Prime_GUI.INPUT_FIELD_NAME);      // UI compoent name not defined

        inputMsgLabelFixture = null;

        calculateButtonFixture = window.button(Prime_GUI.CALCULATE_BUTTON_NAME);
        resetButtonFixture = window.button(Prime_GUI.RESET_BUTTON_NAME);

        isPrimeFieldFixture = window.textBox(Prime_GUI.IS_PRIME_FIELD_NAME);
        primeFactorsFieldFixture = window.textBox(Prime_GUI.PRIME_FACTORS_FIELD_NAME);
    }

    @After
    public void tearDown() {
        window.cleanUp();
    }
    
    @GUITest
    @Test
    public void testInputString() {
        String input = "This is a string";

        String expectedValidInputMsgLabel = Prime_GUI.INVALID_INPUT_MSG;

        // user action - enter the inputs
        inputFieldFixture.enterText(input);
        inputFieldFixture.pressAndReleaseKey(KeyPressInfo.keyCode(KeyEvent.VK_ENTER));
                
        // search the relevant UI compoents when they are now visible
        inputMsgLabelFixture = window.label(Prime_GUI.INPUT_MSG_LABEL_NAME);
        
        // check message content and color
        inputMsgLabelFixture.requireText(expectedValidInputMsgLabel);
        inputMsgLabelFixture.foreground().requireEqualTo(Color.RED);
    }
    
        
    @GUITest
    @Test
    public void testInputDecimal() {
        String input = "10.5";

        String expectedValidInputMsgLabel = Prime_GUI.INVALID_INPUT_MSG;

        // user action - enter the inputs
        inputFieldFixture.enterText(input);
        inputFieldFixture.pressAndReleaseKey(KeyPressInfo.keyCode(KeyEvent.VK_ENTER));
                
        // search the relevant UI compoents when they are now visible
        inputMsgLabelFixture = window.label(Prime_GUI.INPUT_MSG_LABEL_NAME);
        
        // check message content and color
        inputMsgLabelFixture.requireText(expectedValidInputMsgLabel);
        inputMsgLabelFixture.foreground().requireEqualTo(Color.RED);
    }
    
    @GUITest
    @Test
    public void testInputZero() {
        String input = "0";

        String expectedValidInputMsgLabel = Prime_GUI.INVALID_INPUT_MSG;

        // user action - enter the inputs
        inputFieldFixture.enterText(input);
        inputFieldFixture.pressAndReleaseKey(KeyPressInfo.keyCode(KeyEvent.VK_ENTER));
                
        // search the relevant UI compoents when they are now visible
        inputMsgLabelFixture = window.label(Prime_GUI.INPUT_MSG_LABEL_NAME);
        
        // check message content and color
        inputMsgLabelFixture.requireText(expectedValidInputMsgLabel);
        inputMsgLabelFixture.foreground().requireEqualTo(Color.RED);
    }
    
    @GUITest
    @Test
    public void testInputOne() {
        String input = "1";

        String expectedValidInputMsgLabel = Prime_GUI.INVALID_INPUT_MSG;

        // user action - enter the inputs
        inputFieldFixture.enterText(input);
        inputFieldFixture.pressAndReleaseKey(KeyPressInfo.keyCode(KeyEvent.VK_ENTER));
                
        // search the relevant UI compoents when they are now visible
        inputMsgLabelFixture = window.label(Prime_GUI.INPUT_MSG_LABEL_NAME);
        
        // check message content and color
        inputMsgLabelFixture.requireText(expectedValidInputMsgLabel);
        inputMsgLabelFixture.foreground().requireEqualTo(Color.RED);
    }
    
    @GUITest
    @Test
    public void testInputNegative1() {
        String input = "-1";

        String expectedValidInputMsgLabel = Prime_GUI.INVALID_INPUT_MSG;

        // user action - enter the inputs
        inputFieldFixture.enterText(input);
        inputFieldFixture.pressAndReleaseKey(KeyPressInfo.keyCode(KeyEvent.VK_ENTER));
                
        // search the relevant UI compoents when they are now visible
        inputMsgLabelFixture = window.label(Prime_GUI.INPUT_MSG_LABEL_NAME);
        
        // check message content and color
        inputMsgLabelFixture.requireText(expectedValidInputMsgLabel);
        inputMsgLabelFixture.foreground().requireEqualTo(Color.RED);
    }
    
    @GUITest
    @Test
    public void testInputNegative2() {
        String input = "-5000";

        String expectedValidInputMsgLabel = Prime_GUI.INVALID_INPUT_MSG;

        // user action - enter the inputs
        inputFieldFixture.enterText(input);
        inputFieldFixture.pressAndReleaseKey(KeyPressInfo.keyCode(KeyEvent.VK_ENTER));
                
        // search the relevant UI compoents when they are now visible
        inputMsgLabelFixture = window.label(Prime_GUI.INPUT_MSG_LABEL_NAME);
        
        // check message content and color
        inputMsgLabelFixture.requireText(expectedValidInputMsgLabel);
        inputMsgLabelFixture.foreground().requireEqualTo(Color.RED);
    }

    @GUITest
    @Test
    public void testInputLargeNumber1() {
        String input = "2000000001";

        String expectedValidInputMsgLabel = Prime_GUI.INVALID_INPUT_MSG;

        // user action - enter the inputs
        inputFieldFixture.enterText(input);
        inputFieldFixture.pressAndReleaseKey(KeyPressInfo.keyCode(KeyEvent.VK_ENTER));
                
        // search the relevant UI compoents when they are now visible
        inputMsgLabelFixture = window.label(Prime_GUI.INPUT_MSG_LABEL_NAME);
        
        // check message content and color
        inputMsgLabelFixture.requireText(expectedValidInputMsgLabel);
        inputMsgLabelFixture.foreground().requireEqualTo(Color.RED);
    }
    
    @GUITest
    @Test
    public void testInputLargeNumber2() {
        String input = "3000000000";

        String expectedValidInputMsgLabel = Prime_GUI.INVALID_INPUT_MSG;

        // user action - enter the inputs
        inputFieldFixture.enterText(input);
        inputFieldFixture.pressAndReleaseKey(KeyPressInfo.keyCode(KeyEvent.VK_ENTER));
                
        // search the relevant UI compoents when they are now visible
        inputMsgLabelFixture = window.label(Prime_GUI.INPUT_MSG_LABEL_NAME);
        
        // check message content and color
        inputMsgLabelFixture.requireText(expectedValidInputMsgLabel);
        inputMsgLabelFixture.foreground().requireEqualTo(Color.RED);
    }

    @GUITest
    @Test
    public void testIsPrimeNumber1() {
        String input = "2";

        String expectedValidInputMsgLabel = Prime_GUI.VALID_INPUT_MSG;
        String expectedIsPrime = "Yes";
        String expectedPrimeFactors = "Unknown";

        // user action - enter the inputs
        inputFieldFixture.enterText(input);
        inputFieldFixture.pressAndReleaseKey(KeyPressInfo.keyCode(KeyEvent.VK_ENTER));
        
        // user action - click the Calculate button         
        calculateButtonFixture.click();
                
        // search the relevant UI compoents when they are now visible
        inputMsgLabelFixture = window.label(Prime_GUI.INPUT_MSG_LABEL_NAME);
        
        // check message content and color
        inputMsgLabelFixture.requireText(expectedValidInputMsgLabel);
        inputMsgLabelFixture.foreground().requireEqualTo(Color.BLACK);

        // check answers
        isPrimeFieldFixture.requireText(expectedIsPrime);
        primeFactorsFieldFixture.requireText(expectedPrimeFactors);
    }
    
    @GUITest
    @Test
    public void testIsPrimeNumber2() {
        String input = "17";

        String expectedValidInputMsgLabel = Prime_GUI.VALID_INPUT_MSG;
        String expectedIsPrime = "Yes";
        String expectedPrimeFactors = "Unknown";

        // user action - enter the inputs
        inputFieldFixture.enterText(input);
        inputFieldFixture.pressAndReleaseKey(KeyPressInfo.keyCode(KeyEvent.VK_ENTER));
        
        // user action - click the Calculate button        
        calculateButtonFixture.click();
                
        // search the relevant UI compoents when they are now visible
        inputMsgLabelFixture = window.label(Prime_GUI.INPUT_MSG_LABEL_NAME);
        
        // check message content and color
        inputMsgLabelFixture.requireText(expectedValidInputMsgLabel);
        inputMsgLabelFixture.foreground().requireEqualTo(Color.BLACK);

        // check answers
        isPrimeFieldFixture.requireText(expectedIsPrime);
        primeFactorsFieldFixture.requireText(expectedPrimeFactors);
    }
    
    @GUITest
    @Test
    public void testIsPrimeNumber3() {
        String input = "999999937";

        String expectedValidInputMsgLabel = Prime_GUI.VALID_INPUT_MSG;
        String expectedIsPrime = "Yes";
        String expectedPrimeFactors = "Unknown";

        // user action - enter the inputs
        inputFieldFixture.enterText(input);
        inputFieldFixture.pressAndReleaseKey(KeyPressInfo.keyCode(KeyEvent.VK_ENTER));
        
        // user action - click the Calculate button        
        calculateButtonFixture.click();
                
        // search the relevant UI compoents when they are now visible
        inputMsgLabelFixture = window.label(Prime_GUI.INPUT_MSG_LABEL_NAME);
        
        // check message content and color
        inputMsgLabelFixture.requireText(expectedValidInputMsgLabel);
        inputMsgLabelFixture.foreground().requireEqualTo(Color.BLACK);

        // check answers
        isPrimeFieldFixture.requireText(expectedIsPrime);
        primeFactorsFieldFixture.requireText(expectedPrimeFactors);
    } 
    
    @GUITest
    @Test
    public void testGetPrimeFactors1() {
        String input = "87432920";

        String expectedValidInputMsgLabel = Prime_GUI.VALID_INPUT_MSG;
        String expectedIsPrime = "No";
        String expectedPrimeFactors = "2, 2, 2, 5, 463, 4721";

        // user action - enter the inputs
        inputFieldFixture.enterText(input);
        inputFieldFixture.pressAndReleaseKey(KeyPressInfo.keyCode(KeyEvent.VK_ENTER));
        
        // user action - click the Calculate button      
        calculateButtonFixture.click();
                
        // search the relevant UI compoents when they are now visible
        inputMsgLabelFixture = window.label(Prime_GUI.INPUT_MSG_LABEL_NAME);
        
        // check message content and color
        inputMsgLabelFixture.requireText(expectedValidInputMsgLabel);
        inputMsgLabelFixture.foreground().requireEqualTo(Color.BLACK);

        // check answers
        isPrimeFieldFixture.requireText(expectedIsPrime);
        primeFactorsFieldFixture.requireText(expectedPrimeFactors);
    }  
        
    @GUITest
    @Test
    public void testGetPrimeFactors2() {
        String input = "4";

        String expectedValidInputMsgLabel = Prime_GUI.VALID_INPUT_MSG;
        String expectedIsPrime = "No";
        String expectedPrimeFactors = "2, 2";

        // user action - enter the inputs
        inputFieldFixture.enterText(input);
        inputFieldFixture.pressAndReleaseKey(KeyPressInfo.keyCode(KeyEvent.VK_ENTER));
        
        // user action - click the Calculate button         
        calculateButtonFixture.click();
                
        // search the relevant UI compoents when they are now visible
        inputMsgLabelFixture = window.label(Prime_GUI.INPUT_MSG_LABEL_NAME);
        
        // check message content and color
        inputMsgLabelFixture.requireText(expectedValidInputMsgLabel);
        inputMsgLabelFixture.foreground().requireEqualTo(Color.BLACK);

        // check answers
        isPrimeFieldFixture.requireText(expectedIsPrime);
        primeFactorsFieldFixture.requireText(expectedPrimeFactors);
    }  
        
    @GUITest
    @Test
    public void testGetPrimeFactors3() {
        String input = "2000000000";

        String expectedValidInputMsgLabel = Prime_GUI.VALID_INPUT_MSG;
        String expectedIsPrime = "No";
        String expectedPrimeFactors = "2, 2, 2, 2, 2, 2, 2, 2, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5";

        // user action - enter the inputs
        inputFieldFixture.enterText(input);
        inputFieldFixture.pressAndReleaseKey(KeyPressInfo.keyCode(KeyEvent.VK_ENTER));
        
        // user action - click the Calculate button         
        calculateButtonFixture.click();
                
        // search the relevant UI compoents when they are now visible
        inputMsgLabelFixture = window.label(Prime_GUI.INPUT_MSG_LABEL_NAME);
        
        // check message content and color
        inputMsgLabelFixture.requireText(expectedValidInputMsgLabel);
        inputMsgLabelFixture.foreground().requireEqualTo(Color.BLACK);

        // check answers
        isPrimeFieldFixture.requireText(expectedIsPrime);
        primeFactorsFieldFixture.requireText(expectedPrimeFactors);
    }  
}
