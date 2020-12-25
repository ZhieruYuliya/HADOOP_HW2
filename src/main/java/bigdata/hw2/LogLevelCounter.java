package bigdata.hw2;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import scala.Int;
import scala.Tuple2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

import static java.time.temporal.ChronoField.YEAR;

public class LogLevelCounter {
    /**
     * Функция подсчета количества логов разного уровня в час.
     * Парсит строку лога, в т.ч. уровень логирования и час, в который событие было зафиксировано.
     * @param inputRDD - входной DataSet для анализа
     * @return результат подсчета в формате JavaRDD
     */
    public static JavaPairRDD<String, Integer> counLogLevelPerHour(JavaRDD<String> inputRDD){
        JavaPairRDD<String, Integer> rdd = inputRDD.mapToPair(w -> {
            String[] split = w.split("\\s");
            return new Tuple2<String, Integer>(split[1] + ", " + split[2].substring(0,2) + ", " + split[3] , 1);
        });
        JavaPairRDD<String, Integer> transformedRDD = rdd.reduceByKey((x,y) -> x + y).sortByKey();
        return transformedRDD;
    }
}
