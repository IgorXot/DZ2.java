/**
 * zadacha1
 */
public class zadacha1 {

    public static StringBuilder[] getStringBuilderArray(String json) {

        StringBuilder builder = new StringBuilder(); // почему подсвечивается builder?            Создаем пустую изменяему строку
       // String json = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}, {\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}, {\"фамилия\":\"Краснов\",\"оценка$\":\"5\",\"предмет\":\"Физика\"}]";
        System.out.println(json); 
        String[] splitJson = json.split("},"); // разделяет стрроку по },         
        String[][] people = new String[splitJson.length][];
        for (int i = 0; i < splitJson.length; i++) {
            splitJson[i] = splitJson[i].replace("[", ""); //меняем [ на ""
            splitJson[i] = splitJson[i].replace("]", ""); //меняем на ""
            splitJson[i] = splitJson[i].replace("{", ""); //меняем на ""
            splitJson[i] = splitJson[i].replace("}", ""); //меняем на ""
            people[i] = splitJson[i].split(","); // разделяет стрроку по ","
        }
        StringBuilder[] result = new StringBuilder[people.length];
        for (int i = 0; i < people.length; i++) {
            result[i]=new StringBuilder("Студент * получил ^ по предмету #");
            for (int j = 0; j < people[0].length; j++) {
                people[i][j]=people[i][j].replace("\"",""); //меняем на ""
                int indexStart = people[i][j].indexOf(":"); //  ищет в строке заданный символ 
                people[i][j]=people[i][j].substring(indexStart+1); // возвращает новую строку, которая является подстрокой этой строки. Почему плюс 1? 
            }
            int fistPlaceForInsert = result[i].indexOf("*"); // ищет в строке заданный символ 
            result[i].delete(fistPlaceForInsert,fistPlaceForInsert+1);
            result[i].insert(fistPlaceForInsert,people[i][0]); // вставляет строку
            int secondPlaceForInsert = result[i].indexOf("^");
            result[i].delete(secondPlaceForInsert,secondPlaceForInsert+1);
            result[i].insert(secondPlaceForInsert,people[i][1]);
            int thirdPlaceForInsert = result[i].indexOf("#");
            result[i].delete(thirdPlaceForInsert,thirdPlaceForInsert+1);
            result[i].insert(thirdPlaceForInsert,people[i][2]);

        }
return result;
    }
}