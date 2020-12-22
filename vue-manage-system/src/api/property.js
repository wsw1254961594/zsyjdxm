import {get,postJson} from "../network"

export const propertyHttp = {
	list:function(pageNo,pageSize) {
		let param = {
			url:'/property/page',
			data:{
				'pageNo':pageNo,
				'pageSize':pageSize
			}
		}
		return get(param)
	}
}
