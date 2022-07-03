package topics.classes

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-06-03
 *
 *  class User getters and setters
 */

class User {
    var name: String? = null
        get() {
            return if (field == null) {
                ""
            } else {
                field
            }
        }

    var age: Int = 0
        set(value) {
            if (value >= 0) {
                field = value
            }
        }

}