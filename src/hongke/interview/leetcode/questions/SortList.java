package hongke.interview.leetcode.questions;

import hongke.interview.leetcode.common.ListNode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/**
 * Created by hongke on 7/31/14.
 */
public class SortList {

    public ListNode sortListRecursive(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        if (head.next.next != null) {
            ListNode left = head, right = head, node = head, end = null;
            while (node != null) {
                node = node.next;
                if (node != null) {
                    node = node.next;
                }
                end = right;
                right = right.next;
            }
            end.next = null;
            left = sortListRecursive(left);
            right = sortListRecursive(right);
            head = new ListNode(0);
            node = head;
            while (left != null || right != null) {
                if (left != null && right != null && left.val <= right.val) {
                    node.next = left;
                    left = left.next;
                    node = node.next;
                } else if (left != null && right != null && left.val > right.val) {
                    node.next = right;
                    right = right.next;
                    node = node.next;
                } else if (left == null) {
                    node.next = right;
                    right = null;
                } else if (right == null) {
                    node.next = left;
                    left = null;
                }
            }
            return head.next;
        } else {
            ListNode result = head;
            if (head.val > head.next.val) {
                head.next.next = head;
                result = head.next;
                head.next = null;
            }
            return result;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        Stack<ListNode> stack = new Stack<ListNode>();
        Stack<ListNode> sorted = new Stack<ListNode>();

        stack.push(head);
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            ListNode cut = new ListNode(0);
            cut.next = node;
            ListNode left = node, right = node, end = node;
            while (end != null) {
                right = right.next;
                end = end.next;
                cut = cut.next;
                end = end == null ? null : end.next;
            }
            cut.next = null;
            if (right.next == null) {
                sorted.push(right);
            } else {
                stack.push(right);
            }

            if (left.next == null) {
                sorted.push(left);
            } else {
                stack.push(left);
            }

            if (sorted.size() >= 2) {
                ListNode merged = merge(sorted.pop(), sorted.pop());
                sorted.push(merged);
            }
        }

        while (sorted.size() >= 2) {
            ListNode merged = merge(sorted.pop(), sorted.pop());
            sorted.push(merged);
        }

        return sorted.get(0);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode start = new ListNode(0);
        ListNode node = start;
        while (left != null || right != null) {
            if (left == null) {
                node.next = right;
                right = null;
            } else if (right == null) {
                node.next = left;
                left = null;
            } else if (left.val <= right.val) {
                node.next = left;
                left = left.next;
                node = node.next;
            } else {
                node.next = right;
                right = right.next;
                node = node.next;
            }
        }
        return start.next;
    }



    public static void main(String[] args) {
        SortList test = new SortList();
        ListNode input;
        input = ListNode.createLinkedList(new int[] {3, 2, 4});
        ListNode.prettyPrint(test.sortListRecursive(input));

        input = ListNode.createLinkedList(new int[] {4, 19, 14, 5, -3, 1, 8, 5, 11, 15});
        ListNode.prettyPrint(test.sortListRecursive(input));

        input = ListNode.createLinkedList(new int[] {9, 7, 3, 10, 4, 1, 8, 5, 6, 2});
        ListNode.prettyPrint(test.sortListRecursive(input));

        System.out.println(System.currentTimeMillis());
        input = ListNode.createLinkedList(new int[] {883, 299, 563, 850, 257, 886, 179, 859, 459, 586, 649, 955, 483, 271, 685, 167, 177, 895, 865, 560, 178, 578, 145, 625, 441, 805, 386, 951, 557, 2, 424, 474, 68, 491, 328, 479, 302, 199, 221, 888, 462, 191, 73, 66, 931, 114, 863, 233, 631, 355, 801, 212, 116, 529, 869, 494, 550, 924, 761, 232, 646, 653, 245, 499, 50, 148, 830, 281, 622, 605, 408, 425, 700, 789, 718, 559, 197, 530, 748, 660, 753, 434, 833, 692, 758, 376, 860, 882, 861, 346, 896, 732, 759, 480, 603, 365, 672, 512, 9, 674, 82, 588, 276, 710, 51, 311, 138, 760, 726, 419, 889, 721, 296, 3, 243, 261, 877, 118, 594, 965, 541, 960, 994, 72, 96, 273, 747, 767, 356, 509, 878, 554, 246, 807, 84, 195, 902, 797, 391, 163, 628, 728, 304, 406, 227, 440, 71, 1000, 837, 324, 822, 294, 184, 612, 321, 390, 637, 421, 463, 95, 719, 849, 123, 505, 662, 574, 543, 592, 666, 264, 657, 659, 171, 224, 780, 169, 854, 824, 741, 892, 244, 443, 648, 981, 382, 160, 997, 516, 113, 525, 260, 164, 280, 784, 906, 205, 6, 821, 526, 378, 838, 180, 146, 293, 61, 109, 369, 53, 669, 755, 932, 536, 405, 189, 430, 323, 395, 59, 918, 372, 857, 81, 532, 975, 546, 809, 903, 181, 470, 539, 174, 46, 477, 461, 298, 961, 486, 54, 147, 253, 272, 188, 991, 702, 671, 75, 608, 83, 851, 708, 151, 173, 884, 247, 897, 607, 894, 642, 589, 122, 291, 527, 547, 268, 303, 476, 503, 409, 159, 811, 534, 899, 828, 734, 124, 284, 626, 139, 619, 511, 555, 855, 999, 112, 185, 319, 630, 101, 956, 818, 996, 538, 890, 396, 351, 478, 787, 381, 77, 735, 930, 616, 783, 397, 679, 4, 987, 464, 596, 678, 218, 986, 345, 341, 414, 921, 165, 206, 517, 94, 881, 403, 668, 697, 176, 942, 694, 757, 566, 312, 329, 322, 810, 537, 983, 814, 864, 457, 655, 745, 117, 742, 595, 510, 267, 982, 287, 716, 535, 558, 455, 380, 131, 475, 156, 12, 740, 813, 905, 988, 400, 540, 782, 733, 229, 792, 240, 793, 928, 410, 974, 763, 13, 361, 482, 926, 225, 35, 667, 80, 879, 826, 161, 106, 373, 492, 340, 22, 562, 74, 19, 343, 799, 704, 432, 777, 437, 130, 254, 497, 521, 301, 614, 823, 348, 868, 450, 723, 331, 651, 89, 137, 38, 363, 968, 401, 153, 140, 442, 368, 684, 266, 415, 193, 416, 241, 466, 79, 228, 248, 675, 623, 431, 717, 358, 613, 393, 993, 677, 48, 202, 845, 673, 686, 292, 584, 887, 423, 370, 580, 773, 458, 843, 847, 217, 661, 979, 633, 23, 570, 866, 709, 52, 989, 969, 42, 216, 729, 966, 522, 214, 310, 515, 422, 467, 69, 917, 60, 940, 288, 705, 5, 18, 150, 947, 65, 934, 315, 647, 371, 29, 175, 86, 502, 182, 282, 460, 374, 715, 187, 250, 980, 274, 429, 791, 856, 976, 155, 149, 618, 908, 544, 872, 990, 977, 468, 128, 573, 295, 946, 714, 398, 601, 220, 874, 452, 567, 736, 771, 360, 213, 920, 426, 615, 620, 624, 639, 88, 472, 875, 28, 766, 435, 688, 600, 919, 676, 289, 448, 957, 158, 751, 528, 711, 912, 105, 972, 43, 172, 330, 285, 548, 99, 136, 337, 827, 585, 680, 412, 839, 186, 215, 41, 781, 45, 650, 154, 388, 27, 332, 935, 336, 842, 587, 575, 90, 552, 485, 338, 904, 597, 798, 858, 39, 402, 420, 157, 916, 32, 925, 1, 21, 519, 34, 901, 488, 635, 428, 168, 923, 638, 237, 744, 695, 100, 531, 209, 658, 513, 549, 427, 556, 564, 927, 290, 454, 929, 722, 63, 70, 948, 411, 262, 712, 775, 914, 203, 433, 91, 829, 730, 640, 107, 26, 362, 251, 862, 565, 654, 696, 941, 339, 953, 317, 790, 344, 779, 545, 698, 92, 598, 407, 992, 749, 634, 399, 963, 571, 201, 25, 487, 37, 610, 852, 102, 836, 449, 841, 632, 898, 31, 314, 119, 404, 192, 907, 769, 352, 64, 689, 910, 664, 844, 641, 270, 764, 389, 834, 893, 490, 132, 198, 223, 231, 326, 944, 800, 776, 765, 387, 242, 524, 125, 57, 307, 104, 444, 750, 384, 806, 67, 835, 964, 222, 706, 853, 258, 263, 795, 611, 85, 967, 306, 867, 701, 349, 127, 770, 446, 417, 808, 817, 133, 170, 958, 141, 76, 200, 576, 17, 568, 255, 876, 236, 984, 366, 786, 682, 774, 802, 471, 909, 720, 891, 126, 840, 743, 278, 911, 265, 8, 621, 316, 665, 949, 135, 495, 33, 234, 599, 504, 129, 56, 347, 644, 120, 772, 230, 533, 693, 738, 308, 144, 591, 812, 142, 952, 309, 937, 985, 880, 134, 438, 756, 194, 746, 922, 93, 737, 754, 690, 465, 500, 97, 283, 604, 439, 269, 885, 375, 913, 643, 507, 143, 11, 350, 210, 900, 970, 418, 945, 111, 342, 238, 973, 959, 752, 335, 939, 436, 523, 691, 447, 469, 617, 848, 383, 582, 699, 305, 392, 300, 103, 581, 870, 995, 385, 354, 762, 313, 413, 768, 520, 235, 456, 725, 569, 98, 36, 14, 606, 162, 318, 24, 277, 445, 207, 831, 453, 166, 950, 489, 561, 110, 627, 333, 978, 208, 108, 196, 359, 739, 87, 121, 816, 58, 727, 954, 379, 16, 377, 815, 938, 451, 49, 553, 183, 663, 506, 656, 496, 15, 825, 796, 590, 572, 327, 998, 794, 357, 933, 785, 508, 609, 873, 47, 803, 249, 325, 645, 936, 713, 707, 190, 334, 62, 971, 577, 871, 498, 259, 731, 652, 353, 636, 297, 683, 788, 819, 44, 514, 962, 687, 629, 681, 239, 846, 10, 670, 484, 226, 55, 583, 7, 40, 152, 20, 915, 256, 551, 275, 542, 320, 252, 724, 703, 204, 501, 30, 820, 832, 778, 115, 473, 518, 211, 78, 279, 943, 804, 367, 493, 364, 579, 481, 593, 286, 394, 602, 219});
        ListNode.prettyPrint(test.sortListRecursive(input));
        System.out.println(System.currentTimeMillis());

        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("/Users/hongke/numbers.txt")));
            List<Integer> list = new ArrayList<Integer>();
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(Integer.parseInt(line));
            }
            input = ListNode.createLinkedList(list);
            System.out.println(System.currentTimeMillis());
            test.sortListRecursive(input);
            System.out.println(System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
