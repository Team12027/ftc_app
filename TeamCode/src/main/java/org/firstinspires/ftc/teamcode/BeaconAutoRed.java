/* Copyright (c) 2015 Qualcomm Technologies Inc

All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted (subject to the limitations in the disclaimer below) provided that
the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list
of conditions and the following disclaimer.

Redistributions in binary form must reproduce the above copyright notice, this
list of conditions and the following disclaimer in the documentation and/or
other materials provided with the distribution.

Neither the name of Qualcomm Technologies Inc nor the names of its contributors
may be used to endorse or promote products derived from this software without
specific prior written permission.

NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE. */

package org.firstinspires.ftc.teamcode;

import android.app.Activity;
import android.view.View;

import com.qualcomm.ftcrobotcontroller.R;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;

/*
 *
 * This is an example LinearOpMode that shows how to use
 * a Modern Robotics Color Sensor.
 *
 * The op mode assumes that the color sensor
 * is configured with a name of "sensor_color".
 *
 * You can use the X button on gamepad1 to toggle the LED on and off.
 *
 * Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */
@TeleOp(name = "Beacon Auto Test", group = "Sensor")
public class BeaconAutoRed extends LinearOpMode {

  ColorSensor colorSensor;    // Hardware Device Object
  /* Declare OpMode members. */
  HardwarePushbot robot   = new HardwarePushbot();   // Use a Pushbot's hardware

  static final double     DRIVE_SPEED             = 0.6;
  static final double     TURN_SPEED              = 0.5;
  static final int WHITE_THRESHOLD = 10;

  @Override
  public void runOpMode() {

    /*
     * Initialize the drive system variables.
     * The init() method of the hardware class does all the work here
     */
    robot.init(hardwareMap);

    // get a reference to our ColorSensor object.
    colorSensor = hardwareMap.colorSensor.get("sensor_color");

    // Set the LED in the beginning
    colorSensor.enableLed(true);

    // wait for the start button to be pressed.
    waitForStart();

    // while the op mode is active, loop and read the RGB data.
    // Note we use opModeIsActive() as our loop condition because it is an interruptible method.
    while (opModeIsActive()) {

      // drive forward
      robot.leftMotor.setPower(DRIVE_SPEED);
      robot.leftMotor.setPower(DRIVE_SPEED);

//      // small delay to give the sensor some time
//      sleep(10);

      // if white line detected, stop driving and exit loop
      if (colorSensor.red() >= WHITE_THRESHOLD && colorSensor.green() >= WHITE_THRESHOLD && colorSensor.blue() >= WHITE_THRESHOLD) {
        robot.leftMotor.setPower(0);
        robot.rightMotor.setPower(0);

        /** TODO:
         * drive a little farther, then turn until hit white line
         * line follow until proximity sensor (or color sensor) detects that the beacon is close enough
         * use color sensor to detect correct color
         * push button
         * turn and drive to second beacon
         * (repeat above)
         */

        telemetry.addData("White Detection Status", "true");
        telemetry.update();
        break;
      }

      // send the info back to driver station using telemetry
      telemetry.addData("RGB Red  ", colorSensor.red());
      telemetry.addData("RGB Green", colorSensor.green());
      telemetry.addData("RGB Blue ", colorSensor.blue());
      telemetry.update();
    }

    colorSensor.enableLed(false);

  }
}
