export interface LocationReqDTO {
    readonly longitude: number,
    readonly latitude: number,
    readonly radius: number
}

export interface LocationResDTO {
    readonly longitude: number,
    readonly latitude: number,
    readonly json: string
}