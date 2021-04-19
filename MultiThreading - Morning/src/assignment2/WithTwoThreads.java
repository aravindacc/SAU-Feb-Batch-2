package assignment2;

class first_thread extends Thread{
    String str;
    int lengthofString;
    first_thread(String str){
        this.str = str;
        this.lengthofString = str.length();
    }
    public void run()
    {
        int noOfWords = 0;
        WordCounter obj = new WordCounter(str);
        noOfWords = obj.countNoofWords();
        System.out.println("No of words = " + noOfWords);
//        System.out.println("Time taken by first thread to count words in a string of length/2 = " + System.currentTimeMillis());
    }
}



class second_thread extends Thread{
    String str;
    int lengthofString;
    second_thread (String str){
        this.str = str;
        this.lengthofString = str.length();
    }
    public void run()
    {
        int noOfWords = 0;
        WordCounter obj = new WordCounter(str);
        noOfWords = obj.countNoofWords();
        System.out.println("No of words = " + noOfWords);
//        System.out.println("Time taken by second thread to count words in a string of length/2 = " + System.currentTimeMillis());

    }
}

public class WithTwoThreads {
    public static void  main(String[] args) {
        long initialTime = System.currentTimeMillis();
        String str1 = "Although official information is sparse, it is believed that the US military continues" +
                "to use Area 51 to develop cutting-edge aircraft. About 1,500 people are believed to work there, many commuting" +
                "on charter flights from Las Vegas. Annie Jacobsen, who has written about the history of Area 51, told the BBC that" +
                "some of the world's most advanced espionage programmes are at the site. Area 51 is a test and training facility." +
                "The research began with the U-2 spy plane in the 1950s and has now moved on to drones" +
                "Area 51 is the common name of a highly classified United States Air Force (USAF) facility located within the Nevada Test and Training Range." +
                "A remote detachment administered by Edwards Air Force Base, the facility is officially called Homey Airport (KXTA) or Groom Lake (after the salt flat " +
                "situated next to its airfield). Details of the facility's operations are not made public, but the USAF says that it is an open training range, and it is" +
                "commonly thought to support the development and testing of experimental aircraft and weapons systems. The USAF acquired the site in 1955, primarily for " +
                "flight testing the Lockheed U-2 aircraft. The intense secrecy surrounding the base has made it the frequent subject of conspiracy theories and a central" +
                "component of unidentified flying object (UFO) folklore. The base has never been declared a secret base, but all research and occurrences in Area 51 are" +
                "Top Secret/Sensitive Compartmented Information. The CIA publicly acknowledged the existence of the base for the first time on June 25, 2013, following a " +
                "Freedom of Information Act (FOIA) request filed in 2005, and, at the same time, they declassified documents detailing the history and purpose of Area 51." +
                "Area 51 is located in the southern portion of Nevada, 83 miles (134 km) north-northwest of Las Vegas. The surrounding area is a popular tourist destination" +
                "including the small town of Rachel on the Extraterrestrial Highway. The original rectangular base of 6 by 10 miles (9.7 by 16.1 km) is now part of the so" + "called Groom box, a rectangular area measuring 23 by 25 miles (37 by 40 km), of restricted airspace. The area is connected to the internal Nevada Test Site " +
                "(NTS) road network, with paved roads leading south to Mercury and west to Yucca Flat. Leading northeast from the lake, the wide and well-maintained Groom " +
                "Lake Road runs through a pass in the Jumbled Hills. The road formerly led to mines in the Groom basin, but has been improved since their closure." +
                "Its winding course runs past a security checkpoint, but the restricted area around the base extends farther east. After leaving the restricted area, " +
                "Groom Lake Road descends eastward to the floor of the Tikaboo Valley, passing the dirt-road entrances to several small ranches, before converging with State Route 375, the Extraterrestrial Highway, south of Rachel." +
                "Area 51 shares a border with the Yucca Flat region of the Nevada Test Site, the location of 739 of the 928 nuclear tests conducted by the United States " +
                "Department of Energy at NTS.The Yucca Mountain nuclear waste repository is southwest of Groom Lake.The origin of the name Area 51 is unclear. " +
                "It is believed to be from an Atomic Energy Commission (AEC) numbering grid, although Area 51 is not part of this system; it is adjacent to Area 15. " +
                "Another explanation is that 51 was used because it was unlikely that the AEC would use the number.[16] According to the Central Intelligence Agency (CIA), " +
                "the correct names for the facility are Homey Airport (KXTA) and Groom Lake, though the name Area 51 was used in a CIA document from the Vietnam War. " +
                "The facility has also been referred to as Dreamland and Paradise Ranch,[20] among other nicknames. The USAF public relations has referred to the facility " +
                "as an operating location near Groom Dry Lake. The special use airspace around the field is referred to as Restricted Area 4808 North (R-4808N)." +
                "Lead and silver were discovered in the southern part of the Groom Range in 1864, and the English company Groome Lead Mines Limited financed the" +
                "Conception Mines in the 1870s, giving the district its name (nearby mines included Maria, Willow, and White Lake). J. B. Osborne and partners acquired " +
                "the controlling interest in Groom in 1876, and Osbourne's son acquired it in the 1890s. Mining continued until 1918, then resumed after World War II " +
                "until the early 1950s. The airfield on the Groom Lake site began service in 1942 as Indian Springs Air Force Auxiliary Field and consisted of two unpaved 5,000-foot (1,524 m) runways.";


        String str2 = "Although official information is sparse, it is believed that the US military continues" +
                "to use Area 51 to develop cutting-edge aircraft. About 1,500 people are believed to work there, many commuting" +
                "on charter flights from Las Vegas. Annie Jacobsen, who has written about the history of Area 51, told the BBC that" +
                "some of the world's most advanced espionage programmes are at the site. Area 51 is a test and training facility." +
                "The research began with the U-2 spy plane in the 1950s and has now moved on to drones" +
                "Area 51 is the common name of a highly classified United States Air Force (USAF) facility located within the Nevada Test and Training Range." +
                "A remote detachment administered by Edwards Air Force Base, the facility is officially called Homey Airport (KXTA) or Groom Lake (after the salt flat " +
                "situated next to its airfield). Details of the facility's operations are not made public, but the USAF says that it is an open training range, and it is" +
                "commonly thought to support the development and testing of experimental aircraft and weapons systems. The USAF acquired the site in 1955, primarily for " +
                "flight testing the Lockheed U-2 aircraft. The intense secrecy surrounding the base has made it the frequent subject of conspiracy theories and a central" +
                "component of unidentified flying object (UFO) folklore. The base has never been declared a secret base, but all research and occurrences in Area 51 are" +
                "Top Secret/Sensitive Compartmented Information. The CIA publicly acknowledged the existence of the base for the first time on June 25, 2013, following a " +
                "Freedom of Information Act (FOIA) request filed in 2005, and, at the same time, they declassified documents detailing the history and purpose of Area 51." +
                "Area 51 is located in the southern portion of Nevada, 83 miles (134 km) north-northwest of Las Vegas. The surrounding area is a popular tourist destination" +
                "including the small town of Rachel on the Extraterrestrial Highway. The original rectangular base of 6 by 10 miles (9.7 by 16.1 km) is now part of the so" + "called Groom box, a rectangular area measuring 23 by 25 miles (37 by 40 km), of restricted airspace. The area is connected to the internal Nevada Test Site " +
                "(NTS) road network, with paved roads leading south to Mercury and west to Yucca Flat. Leading northeast from the lake, the wide and well-maintained Groom " +
                "Lake Road runs through a pass in the Jumbled Hills. The road formerly led to mines in the Groom basin, but has been improved since their closure." +
                "Its winding course runs past a security checkpoint, but the restricted area around the base extends farther east. After leaving the restricted area, " +
                "Groom Lake Road descends eastward to the floor of the Tikaboo Valley, passing the dirt-road entrances to several small ranches, before converging with State Route 375, the Extraterrestrial Highway, south of Rachel." +
                "Area 51 shares a border with the Yucca Flat region of the Nevada Test Site, the location of 739 of the 928 nuclear tests conducted by the United States " +
                "Department of Energy at NTS.The Yucca Mountain nuclear waste repository is southwest of Groom Lake.The origin of the name Area 51 is unclear. " +
                "It is believed to be from an Atomic Energy Commission (AEC) numbering grid, although Area 51 is not part of this system; it is adjacent to Area 15. " +
                "Another explanation is that 51 was used because it was unlikely that the AEC would use the number.[16] According to the Central Intelligence Agency (CIA), " +
                "the correct names for the facility are Homey Airport (KXTA) and Groom Lake, though the name Area 51 was used in a CIA document from the Vietnam War. " +
                "The facility has also been referred to as Dreamland and Paradise Ranch,[20] among other nicknames. The USAF public relations has referred to the facility " +
                "as an operating location near Groom Dry Lake. The special use airspace around the field is referred to as Restricted Area 4808 North (R-4808N)." +
                "Lead and silver were discovered in the southern part of the Groom Range in 1864, and the English company Groome Lead Mines Limited financed the" +
                "Conception Mines in the 1870s, giving the district its name (nearby mines included Maria, Willow, and White Lake). J. B. Osborne and partners acquired " +
                "the controlling interest in Groom in 1876, and Osbourne's son acquired it in the 1890s. Mining continued until 1918, then resumed after World War II " +
                "until the early 1950s. The airfield on the Groom Lake site began service in 1942 as Indian Springs Air Force Auxiliary Field and consisted of two unpaved 5,000-foot (1,524 m) runways.";

        first_thread fthread = new first_thread(str1);
        second_thread sthread = new second_thread(str2);
        fthread.start();
        sthread.start();
        long finalTime = System.currentTimeMillis();
        long diff = finalTime - initialTime;
        System.out.println("Time taken to count words with 2 threads = " + diff + "ms");
    }
}
