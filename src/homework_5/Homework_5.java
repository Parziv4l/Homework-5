/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework_5;

import com.sun.org.apache.xpath.internal.compiler.Keywords;
import java.util.*;
import jdk.nashorn.internal.objects.Global;

/**
 *
 * @author NicKLz
 */
public class Homework_5 {

    public static int numChars(ArrayList<String> a) {
        int num = 0;
        for (ListIterator<String> it = a.listIterator(); it.hasNext();) {
            String i = it.next();
            num += i.length();
        }
        return num;
    }

    public static void printAlliterations(ArrayList<String> a, ArrayList<String> comp) {
        System.out.println("First Letter Alliterations:");
        for (ListIterator<String> it = a.listIterator(); it.hasNext();) {
            if (it.hasPrevious()) {
                String p = it.previous();
                it.next();
                String i = it.next();
                if (p.charAt(0) == i.charAt(0)) {
                    if (comp.contains(i) || comp.contains(p)) {
                    } else {
                        System.out.println(p + " " + i);
                    }
                }
            } else {
                it.next();
            }
        }
    }

    public static void countChars(ArrayList<String> a) {
        Map<Character, Integer> counts = new HashMap<>();
        for (Iterator<String> it = a.iterator(); it.hasNext();) {
            String i = it.next();
            char[] dst = new char[i.length()];
            i.getChars(0, i.length(), dst, 0);
            for (int j = 0; j < dst.length; j++) {
                if (!counts.containsKey(dst[j])) {
                    counts.put(dst[j], 1);
                } else {
                    counts.put(dst[j], counts.get(dst[j]) + 1);
                }
            }
        }
        Set<Map.Entry<Character, Integer>> countSet = counts.entrySet();
        System.out.println("Character Occurences:");
        for (Iterator<Map.Entry<Character, Integer>> pit = countSet.iterator(); pit.hasNext();) {
            Map.Entry<Character, Integer> k = pit.next();
            System.out.println(k.getKey() + ": " + k.getValue());
        }
    }

    private static void testPerson() {
        Scanner s = new Scanner(System.in);
        int input = 0;
        Student p = new Student("Hunter Stewart",
                "3507 Wellspring lake drive," + " \nFulshear, TX 77441",
                "7138555655",
                "hstewart@tamu.edu",
                Class_Status.SOPHOMORE);
        Faculty q = new Faculty("Donald Trump",
                "3506 Wellspring lake drive, \nFulshear, TX 77441",
                "7138555655",
                "dtrump@makeAmericaGreatAgain.gov", 265, 7.25, new myDate(11,8,2016), "Mon-Fri 10-5", "CEO");
        Staff r = new Staff("Hilary Clinton",
                "3506 Wellspring lake drive, \nFulshear, TX 77441",
                "7138555655",
                "dtrump@makeAmericaGreatAgain.gov", 265, 7.25, new myDate(11,8,2016), "Not the President");
        do {
            System.out.println("Please Select an option: \n1-View Student \n2-View Faculty \n3-View Staff \n0-Exit");
            input = s.nextInt();
            switch (input) {
                case 1:
                    System.out.println("What information would you like? \n1-Name \n2-Class Status");
                    input = s.nextInt();
                    switch (input) {
                        case 1:
                            System.out.println(p);
                            break;
                        case 2:
                            System.out.println(p.getStatus());
                            break;
                    }
                    break;
                case 2:
                    System.out.println("What information would you like? \n1-Name \n2-Office Hours \n3-Rank \n4-Set Hired Date");
                    input = s.nextInt();
                    switch (input) {
                        case 1:
                            System.out.println(q);
                            break;
                        case 2:
                            System.out.println(q.getOfficeHours());
                            break;
                        case 3:
                            System.out.println(q.getRank());
                            break;
                        case 4:
                            System.out.println("Please input the hire date: \nMonth Hired:  ");
                            int month = s.nextInt();
                            System.out.println("Day Hired: ");
                            int day = s.nextInt();
                            System.out.println("Year Hired: ");
                            int year = s.nextInt();
                            q.setDate(month, day, year);
                            System.out.println(q.getDateHired());
                            break;
                    }
                    break;
                case 3:
                    System.out.println("What information would you like? \n1-Name \n2-Title \n3-Set Hired Date");
                    input = s.nextInt();
                    switch (input) {
                        case 1:
                            System.out.println(r);
                            break;
                        case 2:
                            System.out.println(r.getTitle());
                            break;
                        case 3:
                            System.out.println("Please input the hire date: \nMonth Hired:  ");
                            int month = s.nextInt();
                            System.out.println("Day Hired: ");
                            int day = s.nextInt();
                            System.out.println("Year Hired: ");
                            int year = s.nextInt();
                            q.setDate(month, day, year);
                            System.out.println(q.getDateHired());
                            break;
                    }
                    break;
                case 0:
                default:
                    break;
            }
        } while (input != 0);

    }
    
    public static ArrayList<String> bonus(ArrayList<String> f) {
        Map<String, Integer> words = new HashMap<>();
        for (Iterator<String> it = f.iterator(); it.hasNext();) {
            String i = it.next();
                if (!words.containsKey(i)) {
                    words.put(i, 1);
                } else {
                    words.put(i, words.get(i) + 1);
                }
            }
        Set<Map.Entry<String, Integer>> nonDuplicates = words.entrySet();
        ArrayList<String> nonDup = new ArrayList<String>();
        for (Iterator<Map.Entry<String, Integer>> p = nonDuplicates.iterator(); p.hasNext();) {
            Map.Entry<String, Integer> k = p.next();
            if(k.getValue() == 1){
                nonDup.add(k.getKey());
            }
            
        }
        return nonDup;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] allit = {"A", "AN", "AND", "THE", "TO", "OR", "ARE", "AM", "I", "OF", "IS", "AT", "DO", "DOES"};
        ArrayList<String> frankenstein = new ArrayList<String>(Arrays.asList(words));
        ArrayList<String> nonAllit = new ArrayList<String>(Arrays.asList(allit));
        int numChar = numChars(frankenstein);
        int numWord = frankenstein.size();
        double avgChar = (double) numChar / (double) numWord;
        System.out.println("Number of Characters: " + numChar);
        System.out.println("Number of Words: " + numWord);
        System.out.println("Average Number of Characters per word: " + avgChar);
        printAlliterations(frankenstein, nonAllit);
        countChars(frankenstein);
        System.out.println("List of non-duplicate words: ");
        ArrayList<String> bonusArrayList = bonus(frankenstein);
        for(Iterator<String> i = bonusArrayList.iterator(); i.hasNext();){
            String s = i.next();
            System.out.println(s);
        }
        testPerson();
        
    }

    static String[] words = {"YOU", "WILL", "REJOICE", "TO", "HEAR", "THAT", "NO", "DISASTER", "HAS",
        "ACCOMPANIED", "THE", "COMMENCEMENT", "OF", "AN", "ENTERPRISE", "WHICH", "YOU", "HAVE",
        "REGARDED", "WITH", "SUCH", "EVIL", "FOREBODINGS", "I", "ARRIVED", "HERE", "YESTERDAY", "AND",
        "MY", "FIRST", "TASK", "IS", "TO", "ASSURE", "MY", "DEAR", "SISTER", "OF", "MY", "WELFARE", "AND",
        "INCREASING", "CONFIDENCE", "IN", "THE", "SUCCESS", "OF", "MY", "UNDERTAKING", "I", "AM",
        "ALREADY", "FAR", "NORTH", "OF", "LONDON", "AND", "AS", "I", "WALK", "IN", "THE", "STREETS", "OF",
        "PETERSBURGH", "I", "FEEL", "A", "COLD", "NORTHERN", "BREEZE", "PLAY", "UPON", "MY", "CHEEKS",
        "WHICH", "BRACES", "MY", "NERVES", "AND", "FILLS", "ME", "WITH", "DELIGHT", "DO", "YOU",
        "UNDERSTAND", "THIS", "FEELING", "THIS", "BREEZE", "WHICH", "HAS", "TRAVELLED", "FROM", "THE",
        "REGIONS", "TOWARDS", "WHICH", "I", "AM", "ADVANCING", "GIVES", "ME", "A", "FORETASTE", "OF",
        "THOSE", "ICY", "CLIMES", "INSPIRITED", "BY", "THIS", "WIND", "OF", "PROMISE", "MY", "DAYDREAMS",
        "BECOME", "MORE", "FERVENT", "AND", "VIVID", "I", "TRY", "IN", "VAIN", "TO", "BE", "PERSUADED",
        "THAT", "THE", "POLE", "IS", "THE", "SEAT", "OF", "FROST", "AND", "DESOLATION", "IT", "EVER",
        "PRESENTS", "ITSELF", "TO", "MY", "IMAGINATION", "AS", "THE", "REGION", "OF", "BEAUTY", "AND",
        "DELIGHT", "THERE", "MARGARET", "THE", "SUN", "IS", "FOREVER", "VISIBLE", "ITS", "BROAD", "DISK",
        "JUST", "SKIRTING", "THE", "HORIZON", "AND", "DIFFUSING", "A", "PERPETUAL", "SPLENDOUR",
        "THEREFOR", "WITH", "YOUR", "LEAVE", "MY", "SISTER", "I", "WILL", "PUT", "SOME", "TRUST", "IN",
        "PRECEDING", "NAVIGATORSTHERE", "SNOW", "AND", "FROST", "ARE", "BANISHED", "AND", "SAILING",
        "OVER", "A", "CALM", "SEA", "WE", "MAY", "BE", "WAFTED", "TO", "A", "LAND", "SURPASSING", "IN",
        "WONDERS", "AND", "IN", "BEAUTY", "EVERY", "REGION", "HITHERTO", "DISCOVERED", "ON", "THE",
        "HABITABLE", "GLOBE", "ITS", "PRODUCTIONS", "AND", "FEATURES", "MAY", "BE", "WITHOUT",
        "EXAMPLE", "AS", "THE", "PHENOMENA", "OF", "THE", "HEAVENLY", "BODIES", "UNDOUBTEDLY", "ARE",
        "IN", "THOSE", "UNDISCOVERED", "SOLITUDES", "WHAT", "MAY", "NOT", "BE", "EXPECTED", "IN", "A",
        "COUNTRY", "OF", "ETERNAL", "LIGHT", "I", "MAY", "THERE", "DISCOVER", "THE", "WONDROUS",
        "POWER", "WHICH", "ATTRACTS", "THE", "NEEDLE", "AND", "MAY", "REGULATE", "A", "THOUSAND",
        "CELESTIAL", "OBSERVATIONS", "THAT", "REQUIRE", "ONLY", "THIS", "VOYAGE", "TO", "RENDER",
        "THEIR", "SEEMING", "ECCENTRICITIES", "CONSISTENT", "FOREVER", "I", "SHALL", "SATIATE", "MY",
        "ARDENT", "CURIOSITY", "WITH", "THE", "SIGHT", "OF", "A", "PART", "OF", "THE", "WORLD", "NEVER",
        "BEFORE", "VISITED", "AND", "MAY", "TREAD", "A", "LAND", "NEVER", "BEFORE", "IMPRINTED", "BY",
        "THE", "FOOT", "OF", "MAN", "THESE", "ARE", "MY", "ENTICEMENTS", "AND", "THEY", "ARE",
        "SUFFICIENT", "TO", "CONQUER", "ALL", "FEAR", "OF", "DANGER", "OR", "DEATH", "AND",
        "TO", "INDUCE", "ME", "TO", "COMMENCE", "THIS", "LABOURIOUS", "VOYAGE", "WITH", "THE", "JOY",
        "A", "CHILD", "FEELS", "WHEN", "HE", "EMBARKS", "IN", "A", "LITTLE", "BOAT", "WITH", "HIS",
        "HOLIDAY", "MATES", "ON", "AN", "EXPEDITION", "OF", "DISCOVERY", "UP", "HIS", "NATIVE", "RIVER",
        "BUT", "SUPPOSING", "ALL", "THESE", "CONJECTURES", "TO", "BE", "FALSE", "YOU", "CANNOT",
        "CONTEST", "THE", "INESTIMABLE", "BENEFIT", "WHICH", "I", "SHALL", "CONFER", "ON", "ALL",
        "MANKIND", "TO", "THE", "LAST", "GENERATION", "BY", "DISCOVERING", "A", "PASSAGE", "NEAR",
        "THE", "POLE", "TO", "THOSE", "COUNTRIES", "TO", "REACH", "WHICH", "AT", "PRESENT", "SO",
        "MANY", "MONTHS", "ARE", "REQUISITE", "OR", "BY", "ASCERTAINING", "THE", "SECRET", "OF",
        "THE", "MAGNET", "WHICH", "IF", "AT", "ALL", "POSSIBLE", "CAN", "ONLY", "BE", "EFFECTED", "BY",
        "AN", "UNDERTAKING",
        "SUCH", "AS", "MINE", "THESE", "REFLECTIONS", "HAVE", "DISPELLED", "THE", "AGITATION", "WITH",
        "WHICH", "I",
        "BEGAN", "MY", "LETTER", "AND", "I", "FEEL", "MY", "HEART", "GLOW", "WITH", "AN",
        "ENTHUSIASM", "WHICH", "ELEVATES", "ME", "TO",
        "HEAVEN", "FOR", "NOTHING", "CONTRIBUTES", "SO", "MUCH", "TO", "TRANQUILLIZE", "THE",
        "MIND", "AS", "A", "STEADY",
        "PURPOSEA", "POINT", "ON", "WHICH", "THE", "SOUL", "MAY", "FIX", "ITS", "INTELLECTUAL", "EYE",
        "THIS", "EXPEDITION", "HAS",
        "BEEN", "THE", "FAVOURITE", "DREAM", "OF", "MY", "EARLY", "YEARS", "I", "HAVE", "READ", "WITH",
        "ARDOUR", "THE",
        "ACCOUNTS", "OF", "THE", "VARIOUS", "VOYAGES", "WHICH", "HAVE", "BEEN", "MADE", "IN", "THE",
        "PROSPECT", "OF", "ARRIVING",
        "AT", "THE", "NORTH", "PACIFIC", "OCEAN", "THROUGH", "THE", "SEAS", "WHICH", "SURROUND",
        "THE", "POLE", "YOU", "MAY",
        "REMEMBER", "THAT", "A", "HISTORY", "OF", "ALL", "THE", "VOYAGES", "MADE", "FOR",
        "PURPOSES", "OF", "DISCOVERY",
        "COMPOSED", "THE", "WHOLE", "OF", "OUR", "GOOD", "UNCLE", "THOMAS", "LIBRARY", "MY",
        "EDUCATION", "WAS", "NEGLECTED",
        "YET", "I", "WAS", "PASSIONATELY", "FOND", "OF", "READING", "THESE", "VOLUMES", "WERE", "MY",
        "STUDY", "DAY", "AND",
        "NIGHT", "AND", "MY", "FAMILIARITY", "WITH", "THEM", "INCREASED", "THAT", "REGRET", "WHICH",
        "I", "HAD", "FELT", "AS", "A",
        "CHILD", "ON", "LEARNING", "THAT", "MY", "FATHERS", "DYING", "INJUNCTION", "HAD",
        "FORBIDDEN", "MY", "UNCLE", "TO",
        "ALLOW", "ME", "TO", "EMBARK", "IN", "A", "SEAFARING", "LIFE", "THESE", "VISIONS", "FADED",
        "WHEN", "I", "PERUSED", "FOR",
        "THE", "FIRST", "TIME", "THOSE", "POETS", "WHOSE", "EFFUSIONS", "ENTRANCED", "MY", "SOUL",
        "AND", "LIFTED", "IT",
        "TO", "HEAVEN", "I", "ALSO", "BECAME", "A", "POET", "AND", "FOR", "ONE", "YEAR", "LIVED", "IN",
        "A", "PARADISE", "OF", "MY", "OWN",
        "CREATION", "I", "IMAGINED", "THAT", "I", "ALSO", "MIGHT", "OBTAIN", "A", "NICHE", "IN", "THE",
        "TEMPLE", "WHERE", "THE", "NAMES",
        "OF", "HOMER", "AND", "SHAKESPEARE", "ARE", "CONSECRATED", "YOU", "ARE", "WELL",
        "ACQUAINTED", "WITH", "MY",
        "FAILURE", "AND", "HOW", "HEAVILY", "I", "BORE", "THE", "DISAPPOINTMENT", "BUT", "JUST", "AT",
        "THAT", "TIME", "I",
        "INHERITED", "THE", "FORTUNE", "OF", "MY", "COUSIN", "AND", "MY", "THOUGHTS", "WERE",
        "TURNED", "INTO", "THE", "CHANNEL", "OF",
        "THEIR", "EARLIER", "BENT", "SIX", "YEARS", "HAVE", "PASSED", "SINCE", "I", "RESOLVED", "ON",
        "MY", "PRESENT",
        "UNDERTAKING", "I", "CAN", "EVEN", "NOW", "REMEMBER", "THE", "HOUR", "FROM", "WHICH", "I",
        "DEDICATED", "MYSELF", "TO", "THIS",
        "GREAT", "ENTERPRISE", "I", "COMMENCED", "BY", "INURING", "MY", "BODY", "TO", "HARDSHIP",
        "I", "ACCOMPANIED", "THE",
        "WHALEFISHERS", "ON", "SEVERAL", "EXPEDITIONS", "TO", "THE", "NORTH", "SEA", "I",
        "VOLUNTARILY", "ENDURED", "COLD",
        "FAMINE", "THIRST", "AND", "WANT", "OF", "SLEEP", "I", "OFTEN", "WORKED", "HARDER", "THAN",
        "THE", "COMMON", "SAILORS",
        "DURING", "THE", "DAY", "AND", "DEVOTED", "MY", "NIGHTS", "TO", "THE", "STUDY", "OF",
        "MATHEMATICS", "THE", "THEORY", "OF",
        "MEDICINE", "AND", "THOSE", "BRANCHES", "OF", "PHYSICAL", "SCIENCE", "FROM", "WHICH", "A",
        "NAVAL", "ADVENTURER",
        "MIGHT", "DERIVE", "THE", "GREATEST", "PRACTICAL", "ADVANTAGE", "TWICE", "I", "ACTUALLY",
        "HIRED", "MYSELF",
        "AS", "AN", "UNDERMATE", "IN", "A", "GREENLAND", "WHALER", "AND", "ACQUITTED", "MYSELF",
        "TO", "ADMIRATION", "I",
        "MUST", "OWN", "I", "FELT", "A", "LITTLE", "PROUD", "WHEN", "MY", "CAPTAIN", "OFFERED", "ME",
        "THE", "SECOND", "DIGNITY", "IN",
        "THE", "VESSEL", "AND", "ENTREATED", "ME", "TO", "REMAIN", "WITH", "THE", "GREATEST",
        "EARNESTNESS", "SO",
        "VALUABLE", "DID", "HE", "CONSIDER", "MY", "SERVICES", "AND", "NOW", "DEAR", "MARGARET",
        "DO", "I", "NOT", "DESERVE", "TO",
        "ACCOMPLISH", "SOME", "GREAT", "PURPOSE", "MY", "LIFE", "MIGHT", "HAVE", "BEEN", "PASSED",
        "IN", "EASE", "AND", "LUXURY", "BUT", "I",
        "PREFERRED", "GLORY", "TO", "EVERY", "ENTICEMENT", "THAT", "WEALTH", "PLACED", "IN", "MY",
        "PATH", "OH", "THAT", "SOME",
        "ENCOURAGING", "VOICE", "WOULD", "ANSWER", "IN", "THE", "AFFIRMATIVE", "MY", "COURAGE",
        "AND", "MY", "RESOLUTION", "IS",
        "FIRM", "BUT", "MY", "HOPES", "FLUCTUATE", "AND", "MY", "SPIRITS", "ARE", "OFTEN",
        "DEPRESSED", "I", "AM", "ABOUT", "TO",
        "PROCEED", "ON", "A", "LONG", "AND", "DIFFICULT", "VOYAGE", "THE", "EMERGENCIES", "OF",
        "WHICH", "WILL", "DEMAND", "ALL",
        "MY", "FORTITUDE:", "I", "AM", "REQUIRED", "NOT", "ONLY", "TO", "RAISE", "THE", "SPIRITS", "OF",
        "OTHERS", "BUT",
        "SOMETIMES", "TO", "SUSTAIN", "MY", "OWN", "WHEN", "THEIRS", "ARE", "FAILING", "THIS", "IS",
        "THE", "MOST", "FAVOURABLE",
        "PERIOD", "FOR", "TRAVELLING", "IN", "RUSSIA", "THEY", "FLY", "QUICKLY", "OVER", "THE", "SNOW",
        "IN", "THEIR", "SLEDGES",
        "THE", "MOTION", "IS", "PLEASANT", "AND", "IN", "MY", "OPINION", "FAR", "MORE", "AGREEABLE",
        "THAN", "THAT", "OF", "AN",
        "ENGLISH", "STAGECOACH", "THE", "COLD", "IS", "NOT", "EXCESSIVE", "IF", "YOU", "ARE",
        "WRAPPED", "IN", "FURSA", "DRESS",
        "WHICH", "I", "HAVE", "ALREADY", "ADOPTED", "FOR", "THERE", "IS", "A", "GREAT", "DIFFERENCE",
        "BETWEEN", "WALKING",
        "THE", "DECK", "AND", "REMAINING", "SEATED", "MOTIONLESS", "FOR", "HOURS", "WHEN", "NO",
        "EXERCISE",
        "PREVENTS", "THE", "BLOOD", "FROM", "ACTUALLY", "FREEZING", "IN", "YOUR", "VEINS", "I",
        "HAVE", "NO", "AMBITION", "TO", "LOSE",
        "MY", "LIFE", "ON", "THE", "POSTROAD", "BETWEEN", "ST", "PETERSBURGH", "AND", "ARCHANGEL",
        "I", "SHALL",
        "DEPART", "FOR", "THE", "LATTER", "TOWN", "IN", "A", "FORTNIGHT", "OR", "THREE", "WEEKS",
        "AND", "MY", "INTENTION", "IS", "TO",
        "HIRE", "A", "SHIP", "THERE", "WHICH", "CAN", "EASILY", "BE", "DONE", "BY", "PAYING", "THE",
        "INSURANCE", "FOR", "THE",
        "OWNER", "AND", "TO", "ENGAGE", "AS", "MANY", "SAILORS", "AS", "I", "THINK", "NECESSARY",
        "AMONG", "THOSE", "WHO", "ARE",
        "ACCUSTOMED", "TO", "THE", "WHALEFISHING", "I", "DO", "NOT", "INTEND", "TO", "SAIL", "UNTIL",
        "THE", "MONTH", "OF", "JUNE", "AND",
        "WHEN", "SHALL", "I", "RETURN", "AH", "DEAR", "SISTER", "HOW", "CAN", "I", "ANSWER", "THIS",
        "QUESTION", "IF", "I", "SUCCEED",
        "MANY", "MANY", "MONTHS", "PERHAPS", "YEARS", "WILL", "PASS", "BEFORE", "YOU", "AND", "I",
        "MAY", "MEET", "IF", "I", "FAIL", "YOU",
        "WILL", "SEE", "ME", "AGAIN", "SOON", "OR", "NEVER", "FAREWELL", "MY", "DEAR", "EXCELLENT",
        "MARGARET", "HEAVEN",
        "SHOWER", "DOWN", "BLESSINGS", "ON", "YOU", "AND", "SAVE", "ME", "THAT", "I", "MAY", "AGAIN",
        "AND", "AGAIN", "TESTIFY", "MY",
        "GRATITUDE", "FOR", "ALL", "YOUR", "LOVE", "AND", "KINDNESS", "YOUR", "AFFECTIONATE",
        "BROTHER", "R", "WALTON",
        "LETTER", "2", "TO", "MRS", "SAVILLE", "ENGLAND", "ARCHANGEL", "28TH", "MARCH", "17", "HOW",
        "SLOWLY", "THE", "TIME",
        "PASSES", "HERE", "ENCOMPASSED", "AS", "I", "AM", "BY", "FROST", "AND", "SNOW", "YET", "A",
        "SECOND", "STEP", "IS", "TAKEN",
        "TOWARDS", "MY", "ENTERPRISE", "I", "HAVE", "HIRED", "A", "VESSEL", "AND", "AM", "OCCUPIED",
        "IN", "COLLECTING", "MY",
        "SAILORS", "THOSE", "WHOM", "I", "HAVE", "ALREADY", "ENGAGED", "APPEAR", "TO", "BE", "MEN",
        "ON", "WHOM", "I", "CAN", "DEPEND", "AND",
        "ARE", "CERTAINLY", "POSSESSED", "OF", "DAUNTLESS", "COURAGE", "BUT", "I", "HAVE", "ONE",
        "WANT", "WHICH", "I",
        "HAVE", "NEVER", "YET", "BEEN", "ABLE", "TO", "SATISFY", "AND", "THE", "ABSENCE", "OF", "THE",
        "OBJECT", "OF", "WHICH", "I", "NOW",
        "FEEL", "AS", "A", "MOST", "SEVERE", "EVIL", "I", "HAVE", "NO", "FRIEND",
        "MARGARET:", "WHEN", "I", "AM", "GLOWING", "WITH", "THE",
        "ENTHUSIASM", "OF", "SUCCESS", "THERE", "WILL", "BE", "NONE", "TO", "PARTICIPATE", "MY", "JOY",
        "IF", "I", "AM", "ASSAILED", "BY",
        "DISAPPOINTMENT", "NO", "ONE", "WILL", "ENDEAVOUR", "TO", "SUSTAIN", "ME", "IN",
        "DEJECTION", "I", "SHALL", "COMMIT", "MY",
        "THOUGHTS", "TO", "PAPER"
    };

    

}
