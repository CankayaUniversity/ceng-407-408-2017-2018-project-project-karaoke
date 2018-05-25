package UserStatic;

import java.util.Date;

/**
 *
 * @author mehmetali
 */

/**
 * numUserType == 1 => Admin
 * numUserType == 2 => FamilyUser
 * numUserType == 3 => Teacher
 */

public class UserSession {
    public static String strName;
    public static int numUserId;
    public static int numUserType;
    public static  Date enterDate;
    public static Date exitDate;
}
