package test;

public class Library {

    private String[] list;
    private int count;

    public int getLibrary() {
        return list.length;
    }

    public int getCount() {
        return count;
    }

    public Library(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("도서관의 크기는 1보다 작은 값을 넣을 수 없습니다.");
        }
        list = new String[size];
        count = 0;

        for (int i = 0; i < size; i++) {
            list[i] = " ";
        }
    }


    public void add(String str) {
        if (count == list.length) {
            throw new IllegalArgumentException("책장이 꽉 찼습니다.");
        }
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(str)) {
                throw new IllegalArgumentException(str + "은 이미 있습니다.");
            }
        }

        list[count] = str;
        System.out.println(str + "책을 추가 했습니다.");
        count++;


    }

    public void delete(String str) {
        if (count == 0) {
            throw new IllegalArgumentException("책장이 비어있습니다.");
        }
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(str)) {
                for (int j = i; j < list.length - 1; j++) {
                    list[j] = list[j + 1];
                }
                list[list.length - 1] = "";
                count -= 1;
                return;
            }
        }
        throw new IllegalArgumentException(str + "은(는) 지울 수 없습니다.");
    }

    public void find(String str) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(str)) {
                System.out.println("책 검사 결과 : " + str);
                return;
            }
        }
        System.out.println("검색 결과가 없습니다.");
    }

    public void findAll() {

        System.out.println("모든 책 출력 : ");
        System.out.println("==================");
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals("")) {
                continue;
            }
            System.out.println((i + 1) + " : " + list[i]);
        }
        System.out.println("==================");
    }
}
