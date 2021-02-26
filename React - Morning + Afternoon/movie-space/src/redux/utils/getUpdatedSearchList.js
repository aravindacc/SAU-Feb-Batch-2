export const getUpdatedSearchList = (searchList, query) => {
    return searchList.filter(item => {
        return item.title.startsWith(query);
    })
}