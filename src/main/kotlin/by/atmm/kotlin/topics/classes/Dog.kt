package topics.classes

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-07-03
 *
 *  Class Dog getters and setters
 *  String functions
 */

class Dog {
    var name = ""
        get() = field.lowercase().replaceFirstChar { it.uppercase() }
    // deprecated
    // get() = field.toLowerCase().capitalize();

    var age = 0
        set(value) {
            if (value >= 0) {
                field = value
            }
        }

    var weight = 0f
        set(value) {
            if (value >= 0) {
                field = value
            }
        }
}