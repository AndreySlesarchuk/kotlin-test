package by.atmm.kotlin.topics.datasource


object Demo {
    @JvmStatic
    fun main(args: Array<String>) {
        val salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000"
        val encoded: DataSourceDecorator = CompressionDecorator(
            EncryptionDecorator(
                FileDataSource("d:/OutputDemo.txt")
            )
        )
        encoded.writeData(salaryRecords)
        val plain: DataSource = FileDataSource("d:/OutputDemo.txt")
        println("- Input ----------------")
        println(salaryRecords)
        println("- Encoded --------------")
        System.out.println(plain.readData())
        println("- Decoded --------------")
        System.out.println(encoded.readData())
    }
}