export const getBookDetails = (booksList, isbn) => {

    for (let i = 0; i < booksList.length; i++) {
        if (booksList[i].ISBN.toString() === isbn) {
            return booksList[i];
        }
    }
    return {};
}