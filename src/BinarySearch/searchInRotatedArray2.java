package BinarySearch;

public class searchInRotatedArray2 {
    public static void main(String[] args) {
        int[] arr = {2,5,6,0,0,1,2};
//        int[] arr = {371, 376, 378, 381, 383, 389, 391, 393, 395, 397, 400, 401, 404, 407, 413, 418, 419, 423, 429, 430, 431, 432, 433, 437, 440, 441, 442, 443, 446, 447, 449, 451, 452, 458, 459, 466, 467, 468, 473, 474, 477, 478, 480, 484, 485, 489, 493, 495, 496, 501, 502, 504, 505, 507, 508, 509, 511, 513, 514, 521, 524, 527, 528, 529, 530, 531, 534, 535, 539, 541, 543, 545, 546, 550, 552, 553, 554, 555, 558, 559, 561, 562, 565, 572, 573, 574, 576, 581, 583, 585, 586, 587, 588, 590, 592, 601, 607, 608, 609, 610, 611, 612, 614, 615, 617, 618, 620, 623, 624, 625, 627, 629, 631, 632, 634, 637, 639, 644, 651, 653, 655, 656, 657, 659, 661, 662, 670, 680, 681, 683, 686, 688, 691, 693, 694, 697, 698, 703, 705, 706, 707, 708, 712, 716, 717, 718, 719, 727, 729, 736, 738, 742, 743, 745, 747, 749, 755, 758, 760, 763, 764, 765, 766, 767, 769, 771, 772, 773, 775, 778, 780, 781, 783, 785, 787, 791, 795, 797, 798, 801, 803, 806, 810, 814, 815, 816, 818, 819, 822, 825, 826, 828, 829, 830, 832, 836, 837, 840, 845, 848, 851, 853, 859, 862, 866, 867, 868, 869, 872, 874, 875, 879, 880, 882, 883, 888, 890, 893, 894, 898, 899, 900, 903, 905, 909, 912, 913, 914, 918, 922, 928, 930, 935, 937, 940, 944, 945, 946, 947, 954, 957, 959, 960, 961, 963, 968, 970, 971, 973, 975, 976, 977, 979, 982, 984, 987, 989, 991, 992, 993, 995, 997, 3, 5, 6, 9, 11, 18, 20, 21, 22, 27, 28, 31, 33,35, 38, 39, 41, 47, 49, 51, 53, 54, 55, 56, 58, 59, 62, 67, 70, 71, 73, 75, 84, 89, 92, 95, 97, 99, 102, 108, 110, 112, 117, 118, 119, 121, 124, 125, 126, 129, 130, 131, 132, 139, 140, 141, 142, 143, 148, 149, 150, 151, 152, 153, 155, 156, 158, 159, 160, 161, 164, 167, 168, 172, 173, 174, 177, 184, 187, 188, 192, 194, 197, 198, 200, 204, 205, 206, 213, 216, 220, 224, 226, 229, 230, 235, 239, 241, 248, 250, 251, 252, 253, 255, 256, 257, 258, 260, 261, 264,
//268, 272, 276, 278, 280, 284, 288, 290, 291, 293, 296, 297, 299, 301, 303, 305, 307, 309, 312, 317, 318, 323, 324, 325, 326, 327, 328, 330, 336, 337,
//338, 340, 342, 343, 347, 348, 351, 353, 355, 356, 359, 361, 362, 364, 366, 369};
        int n = arr.length;
        int target = 1;

//        First find the index of peak element
//        int peak = 0, idx = 0;
//        if (arr[0]>arr[1]) {
//            peak = arr[0];
//        }
//        for (int i = 1; i < n-1; i++) {
//            if (arr[i]>=arr[i-1] && arr[i]>=arr[i+1]) {
//                peak = arr[i];
//                idx = i;
//            }
//        }
//        if (peak==0 && arr[n-1]>=arr[n-2]) {
//            peak = arr[n-1];
//            idx = n-1;
//        }
//        System.out.println(idx);
//        System.out.println(arr[idx]);
//        peak = idx;


//        Now run binary search two times
//        boolean bol1 = binarySearch(arr, 0, peak, target);
//        System.out.println(bol1);
//        boolean bol2 = binarySearch(arr, peak+1, n-1, target);
//        System.out.println(bol2);
//        System.out.println((bol1||bol2));


//        Second approach
        int l = 0, h = n-1, m=0;
        while (l<=h) {
            m = (l+h)/2;
            if (arr[m]==target || arr[l]==target || arr[h]==target) {
                System.out.println(true);
                return;
            }
            if (arr[l]>target && arr[h]>target) {
                l++;
                h--;
            } else if (arr[l]>arr[m]) {
                if (arr[m]>target) h = m-1;
                else l = m+1;
            } else {
                if (arr[m]>target) l=m+1;
                else h=m-1;
            }
        }

    }

    private static boolean binarySearch(int[]arr, int l, int h, int k) {
        int m = 0;
        while (l<=h) {
            m = (l+h)/2;
            if (arr[m]==k) {
                return true;
            }
            else if (arr[m] > k) {
                h = m-1;
            } else {
                l = m+1;
            }
        }
        return false;
    }
}