class Solution {
    public String reformatDate(String date) {
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
                            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        
        Map<String, String> monthMap = new HashMap<>();
        for (int i = 0; i < months.length; i++) {
            monthMap.put(months[i], String.format("%02d", i + 1));
        }

        String[] parts = date.split(" ");
        String day = parts[0].substring(0, parts[0].length() - 2); // strip "st"/"nd"/"rd"/"th"
        if (day.length() == 1) {
            day = "0" + day;
        }
        String month = monthMap.get(parts[1]);
        String year = parts[2];

        return year + "-" + month + "-" + day;
    }
}
