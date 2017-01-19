package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * This OpMode scans a single servo back and forwards until Stop is pressed.
 * The code is structured as a LinearOpMode
 * INCREMENT sets how much to increase/decrease the servo position each cycle
 * CYCLE_MS sets the update period.
 *
 * This code assumes a Servo configured with the name "left claw" as is found on a pushbot.
 *
 * NOTE: When any servo position is set, ALL attached servos are activated, so ensure that any other
 * connected servos are able to move freely before running this test.
 *
 * Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */
@TeleOp(name = "Beacon Servo Test", group = "Concept")
@Disabled
public class BeaconServoTest extends LinearOpMode {

    // Define class members
    Servo   servo;
    @Override
    public void runOpMode() {

        // Connect to servo (Assume PushBot Left Hand)
        // Change the text in quotes to match any servo name on your robot.
        servo = hardwareMap.servo.get("left_beacon");

        // Wait for the start button
        //telemetry.addData(">", "Press Start to scan Servo." );
        //telemetry.update();
        waitForStart();


        // Scan servo till stop pressed.
        while(opModeIsActive()){

          if (gamepad2.x) {
              servo.setPosition(0);
          } else {
              servo.setPosition(90);
          }
            // Set the servo to the new position and pause;
         //   servo.setPosition(position);
            //sleep(CYCLE_MS);
            //idle();
        }

        // Signal done;
      //  telemetry.addData(">", "Done");
       // telemetry.update();
    }
}
