/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public final static int kVictorPort0 = 0;
    public final static int kVictorPort1 = 1;
    public final static int kVictorPort2 = 2;
    public final static int kVictorPort3 = 3;
    
    public final static int directionFactor = -1; // speeds were reversed

    public final static double autoTimeToDrive = 2.0; // drive 2 seconds in autonomous mode

    public static final class OI {
        public final static int kController = 0;
    }
}
