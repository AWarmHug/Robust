package robust.gradle.plugin.asm;


import org.gradle.internal.impldep.com.google.common.base.Preconditions;
import org.gradle.internal.impldep.org.eclipse.jgit.annotations.NonNull;

public class AsmUtils {

    private AsmUtils() {}

    public static final String CONSTRUCTOR = "<init>";
    public static final String CLASS_INITIALIZER = "<clinit>";

    /**
     * Converts a class name from the Java language naming convention (foo.bar.baz) to the JVM
     * internal naming convention (foo/bar/baz).
     */
    @NonNull
    public static String toInternalName(@NonNull String className) {
        return className.replace('.', '/');
    }

    /**
     * Gets the class name from a class member internal name, like {@code com/foo/Bar.baz:(I)V}.
     */
    @NonNull
    public static String getClassName(@NonNull String memberName) {
        Preconditions.checkArgument(memberName.contains("."), "Class name passed as argument.");
        return memberName.substring(0, memberName.indexOf('.'));
    }
}