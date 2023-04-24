export interface HotelModel {
    name: string,
    type: string,
    description: string,
    body: string,
    rating: number,
    nearestMRTStation: string,
    officialWebsite: string,
    officialEmail: string,
    reviews: reviewData[],
    image: string


}

export interface reviewData{
    authorName: string,
    authorURL: string,
    language: string,
    profilePhoto: string,
    rating: string,
    text: string,
    time: string,
}

// export interface metadata{
//     updatedDate: string,
//     createdDate: string,
// }