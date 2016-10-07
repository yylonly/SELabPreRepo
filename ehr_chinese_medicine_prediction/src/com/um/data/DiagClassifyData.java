package com.um.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiagClassifyData {

	
	public final static String[] cnDiagClassify = {"肺癌|气虚|痰瘀|互结",
		"肺癌|气虚|痰瘀|阻络",
		"肺癌|气阴两虚|痰瘀|互结",
		"肺癌|脾虚|痰瘀|互结",
		"肺癌|气虚|痰湿|瘀阻",
		"肺癌|脾虚|湿瘀|互结",
		"肺癌|气虚|痰瘀|热结",
		"肺癌|气阴两虚|夹热",
		"肺癌|气虚|痰湿|瘀热|互结",
		"肺癌|气虚|湿阻"};
	
	public final static String[] cnDiagCodeStrings = {
			"气虚|K2",
			"痰瘀|K3",
			"互结|K4",
			"阻络|K5",
			"气阴两虚|K6",
			"脾虚|K7",
			"痰湿|K8",
			
			"热结|K10",
			"湿瘀|K11",
			"夹热|K12",
			"瘀热|K13",
			"湿阻|K14"};
	
	public final static String[] wnDiagClassify = {"肺恶性肿瘤",
		"肺恶性肿瘤|高血压病",
		"肺恶性肿瘤|脂肪肝",
		"肺恶性肿瘤|糖尿病",
		"肺恶性肿瘤|乳腺恶性肿瘤",
		"肺恶性肿瘤|子宫肌瘤",
		"右肺恶性肿瘤|中分化腺癌|脑膜瘤",
		"右肺恶性肿瘤|中分化腺癌|糖尿病",
		"右肺恶性肿瘤|中分化腺癌|IV期",
		"肺恶性肿瘤|中央型肺癌",
		"左肺恶性肿瘤|中分化腺癌",
		"左肺恶性肿瘤",
		"左肺恶性肿瘤|低分化|淋巴上皮瘤样癌",
		"左肺恶性肿瘤|低分化|淋巴上皮瘤样癌|肝",
		"左肺恶性肿瘤|右肺多发结节",
		"左肺恶性肿瘤|小细胞癌",
		"左肺恶性肿瘤|鳞癌",
		"左肺恶性肿瘤|下叶腺癌",
		"左肺恶性肿瘤|肺结核",
		"左肺恶性肿瘤|肉瘤样癌|右肺恶性肿瘤",
		"左肺恶性肿瘤|肝转移",
		"左肺恶性肿瘤|肺结核",
		"左肺恶性肿瘤|浸润性腺癌",
		"右肺恶性肿瘤|鳞癌",
		"右肺恶性肿瘤",
		"右肺恶性肿瘤|低分化腺癌骨转移",
		"右肺恶性肿瘤|细支气管肺泡癌",
		"右肺恶性肿瘤|细支气管肺泡癌|中低分化腺癌",
		"右肺恶性肿瘤|腺癌",
		"右肺恶性肿瘤|左肺及脑转移",
		"右肺恶性肿瘤|大细胞癌",
		"右肺恶性肿瘤|小细胞癌",
		"左下肺",
		"右下肺恶性肿瘤|鳞癌",
		"右下肺恶性肿瘤|小细胞肺癌",
		"右上肺性肿瘤",
		"肺癌",
		"肺恶性肿瘤IV期",
		"肺恶性肿瘤|中低分化",
		"肺恶性肿瘤|弥漫性|高分化",
		"肺恶性肿瘤|右肺",
		"肺恶性肿瘤|右下肺",
		"肺恶性肿瘤|腺Ca",
		"肺恶性肿瘤|浸润性",
		"肺恶性肿瘤|直肠恶性肿瘤",
		"肺恶性肿瘤|脑继发恶性肿瘤",
		"肺恶性肿瘤|左肺",
		"肺恶性肿瘤|右肺",
		"肺恶性肿瘤|左上肺",
		"肺恶性肿瘤|右上肺",
		"肺恶性肿瘤|低分化",
		"肺恶性肿瘤|低分化鳞癌",
		"肺恶性肿瘤|脑膜瘤",
		"肺恶性肿瘤|主动脉夹层|高血压病|糖尿病",
		"右肺|pT1N2M0",
		"右上肺恶性肿瘤|鳞癌",
		"右上肺恶性肿瘤|中分化",
		"右上肺恶性肿瘤|IV期",
		"右上肺恶性肿瘤|低分化",
		"右上肺恶性肿瘤|肉瘤样癌",
		"左下肺恶性肿瘤|pT2N0M0",
		"左下肺恶性肿瘤|中分化",
		"左下肺恶性肿瘤|低分化",
		"左下肺恶性肿瘤|pT4N2M1a",
		"双肺、骨多发转移肝恶性肿瘤|胆管细胞癌",
		"右肺鳞癌",
		"左下肺占位性病变|周围型肺Ca",
		"右肺肺恶性肿瘤|T1N0M0",
		"右下肺肿瘤|高血压病|冠心病",
		"肺恶性淋巴瘤",
		"右上肺肺腺鳞癌",
		"左上肺恶性肿瘤|鳞癌",
		"左上肺恶性肿瘤|高分化",
		"左上肺恶性肿瘤|pT1bN0M0|IA期",
		"左上肺恶性肿瘤",
		"左上肺恶性肿瘤|IIIb期",
		"右中肺恶性肿瘤|pT1bN0M0|IA期",
		"右中肺恶性肿瘤|中分化|cT4N1M0",
		"右中肺恶性肿瘤",
		"右下肺|T3N0M1|肝",
		"左下肺肺泡癌",
		"左上肺恶性肿瘤|双肺转移|T4N2M1a",
		"左上肺恶性肿瘤|肺门淋巴结转移"};
	
	public final static String[]  cndescriclassify = {
		"纳眠尚可|K2",
		"纳可眠差|K3",
		"纳眠一般|K4",
		"纳差眠可|K5",
		"纳可眠一般|K6",
		"纳眠差|K7",
		"纳可眠稍差|K8",
		"纳差眠好转|K9",
		"纳可眠好转|K10",
		"眠差改善|K11",
		"纳差眠改善|K12",
		"纳欠佳眠一般|K13",
		"纳一般眠差|K14",
		"纳眠欠佳|K15",
		"纳眠俱差|K16",
		"纳改善眠可|K17",
		"纳差眠欠佳|K18",
		"纳眠好转|K19",
		"纳眠稍差|K20",
		"二便失禁|K23",
		"二便可|K24",
		"大便欠通畅|K26",
		"恶心呕吐|K27",
		"腹胀闷|K28",
		"干呕|K29",
		"小便次多|K30",
		"尿频|K31",
		"上腹隐痛|K32",
		"上腹隐痛缓解|K33",
		"舌质淡|K34",
		"舌苔微黄|K35",
		"舌质红|K36",
		"舌苔白|K37",
		"舌质暗红|K38",
		"舌苔黄|K39",
		"舌苔黄微腻|K40",
		"舌苔黄腻|K41",
		"舌红苔微黄|K42",
		"舌淡苔微黄|K43",
		"舌红苔少|K44",
		"舌苔染色|K45",
		"舌质紫暗|K46",
		"舌苔薄白|K47",
		"脉弦细|K48",
		"脉细滑|K49",
		"脉弦滑|K50",
		"脉细|K51",
		"脉滑|K52",
		"发热缓解|K53",
		"咳嗽咯痰|K54",
		"少许咳嗽|K55",
		"咳嗽痰多|K56",
		"咳嗽咽痒|K57",
		"咳嗽少气|K58",
		"咳嗽稍好转|K60",
		"咳嗽缓解|K61",
		"咳嗽无痰|K62",
		"少咳痰粘|K63",
		"干咳|K64",
		"偶有干咳|K65",
		"咳嗽加重|K66",
		"咳嗽少痰|K67",
		"偶咳嗽|K68",
		"咳嗽较剧|K69",
		"咳嗽痰少|K70",
		"咯少量血痰|K71",
		"咳嗽痰色白|K72",
		"痰血减少|K73",
		"咳嗽频繁|K74",
		"咯黄白痰|K75",
		"偶咯痰|K76",
		"痰白可咯|K77",
		"痰多色黄|K78",
		"痰少色白|K79",
		"少痰难咯|K80",
		"黄痰难咯|K81",
		"痰血加重|K82",
		"咯黄白色稀痰|K83",
		"白痰|K84",
		"咯痰|K85",
		"仍耳鸣|K86",
		"咳嗽少作|K87",
		"痰黄白|K88",
		"咳嗽好转|K89",
		"咳嗽少|K90",
		"少白痰|K91",
		"咳嗽胸闷|K92",
		"痰多色灰白|K93",
		"痰中带血|K94",
		"痰色黄难咯|K95",
		"偶有痰血|K96",
		"痰难咯|K97",
		"痰浓稠|K98",
		"咯白|K99",
		"痰色白|K100",
		"咯血痰|K101",
		"偶有咳嗽|K102",
		"咳嗽反复|K104",
		"咳嗽痰血|K105",
		"咳嗽减少|K106",
		"咳嗽痰白|K107",
		"咯黄色稀痰|K108",
		"咽中有痰|K109",
		"量少色黄|K110",
		"仍倦怠欲眠|K111",
		"咽干|K112",
		"咯黄痰|K113",
		"少许血丝痰|K114",
		"偶咳少痰|K115",
		"痰多色白|K116",
		"偶咳|K117",
		"时有呕吐|K118",
		"咯黄白粘痰|K119",
		"痰减少|K120",
		"痰中血丝|K121",
		"痰粘|K122",
		"少量痰血|K123",
		"近汗多|K124",
		"胸痛|K125",
		"胸闷缓解|K126",
		"胸闷少气|K127",
		"偶胸闷|K128",
		"少许胸闷|K129",
		"胸痛缓解|K130",
		"偶有胸闷|K131",
		"胸闷不适|K132",
		"偶胸痛|K133",
		"夜间胸痛|K134",
		"右侧胸痛|K135",
		"时有胸闷|K136",
		"偶有吞咽困难|K137",
		"心慌心悸|K138",
		"眠差梦多|K139",
		"胸闷胸痛|K140",
		"肩背疼痛|K141",
		"周身酸痛|K142",
		"下肢酸软|K143",
		"下肢水肿|K144",
		"下肢疼痛|K145",
		"心悸缓解|K146",
		"胸部胀闷|K147",
		"气促|K148",
		"少气好转|K149",
		"少气自汗|K150",
		"少气心悸|K151",
		"偶有心悸|K152",
		"时倦怠|K153",
		"少气缓解|K154",
		"少气乏力|K155",
		"困倦乏力|K156",
		"头晕乏力|K157",
		"少气好转|K158",
		"口干咽痛|K159",
		"口干减轻|K160",
		"口干欲呕|K161",
		"口腔溃疡|K162",
		"耳鸣好转|K163",
		"倦怠乏力|K164",
		"倦怠少气|K165",
		"偶有少气|K166",
		"仍气短|K167",
		"便秘|K168",
		"便秘缓解|K169",
		"大便难解|K170",
		"腹泻缓解|K171",
		"小便多|K172",
		"时腹泻|K174",
		"大便次数多|K175",
		"时便溏|K176",
		"便溏|K177",
		"便溏缓解|K178",
		"便烂|K179",
		"偶有呕吐|K180",
		"大便难排|K181",
		"小便短少|K182",
		"大便尚可|K183",
		"呕吐已止|K184",
		"小便可|K185",
		"大便次多|K186",
		"胃脘不适|K187",
		"胃脘不适缓解|K188",
		"大便时腹痛|K189",
		"夜尿多|K190",
		"腹胀好转|K191",
		"无恶心欲呕|K192",
		"恶心欲呕|K193",
		"泛酸胃痛|K194",
		"大便不畅|K195",
		"尿血|K196",
		"夜尿频|K197",
		"大便可|K198",
		"动则出汗|K199",
		"偶头痛|K201",
		"头晕缓解|K203",
		"偶有头晕|K204",
		"头晕好转|K205",
		"头晕指麻|K206",
		"时感眩晕|K207",
		"偶指麻|K208",
		"时有头晕|K209",
		"咽痒咳嗽|K211",
		"声嘶好转|K212",
		"咽痒不适|K213",
		"吞咽欠畅|K214",
		"咽痒减轻|K215",
		"吞咽不畅|K216",
		"吞咽困难|K217",
		"吞咽不适|K218",
		"咽痒声嘶|K219",
		"平素焦虑紧张|K220",
		"易倦怠|K221",
		"气短盗汗|K222",
		"胀闷不适|K223",
		"鼻咽不适|K224",
		"乏力缓解|K225",
		"疲倦乏力|K226",
		"腹胀腰酸|K227",
		"腰背痛|K228",
		"骨痛|K229",
		"腰痛|K230",
		"腰椎疼痛|K231",
		"心悸胸痛|K232",
		"眼睛疼痛|K233",
		"胸背痛缓解|K234",
		"隐痛缓解|K235",
		"腰背痛缓解|K236",
		"膝关节痛缓解|K237",
		"偶发头痛|K238",
		"胸肋疼痛|K239",
		"胸背痛|K240",
		"偶牙龈出血|K241",
		"胸闷痛减轻|K242",
		"皮疹瘙痒|K243",
		"少许肤痒|K244",
		"皮疹瘙痒缓解|K245",
		"皮疹瘙痒较重|K246",
		"瘙痒减轻|K247",
		"皮疹轻微|K248",
		"肤痒缓解|K249",
		"皮疹肤痒|K250",
		"肢体乏力|K252",
		"潮热自汗|K254",
		"反复低热|K255",
		"口苦|K258",
		"心悸气短|K259",
		"嗳气|K260",
		"矢气多|K261"};
	
	public final static String[]  cndescriclassify1 = {"纳眠可|K1",
		"纳眠尚可|K2",
		"纳可眠差|K3",
		"纳眠一般|K4",
		"纳差眠可|K5",
		"纳可眠一般|K6",
		"纳眠差|K7",
		"纳可眠稍差|K8",
		"纳差眠好转|K9",
		"纳可眠好转|K10",
		"眠差改善|K11",
		"纳差眠改善|K12",
		"纳欠佳眠一般|K13",
		"纳一般眠差|K14",
		"纳眠欠佳|K15",
		"纳眠俱差|K16",
		"纳改善眠可|K17",
		"纳差眠欠佳|K18",
		"纳眠好转|K19",
		"纳眠稍差|K20",
		"二便调|K21",
		"小便调|K22",
		"二便失禁|K23",
		"二便可|K24",
		"大便调|K25",
		"大便欠通畅|K26",
		"恶心呕吐|K27",
		"腹胀闷|K28",
		"干呕|K29",
		"小便次多|K30",
		"尿频|K31",
		"上腹隐痛|K32",
		"上腹隐痛缓解|K33",
		"舌质淡|K34",
		"舌苔微黄|K35",
		"舌质红|K36",
		"舌苔白|K37",
		"舌质暗红|K38",
		"舌苔黄|K39",
		"舌苔黄微腻|K40",
		"舌苔黄腻|K41",
		"舌红苔微黄|K42",
		"舌淡苔微黄|K43",
		"舌红苔少|K44",
		"舌苔染色|K45",
		"舌质紫暗|K46",
		"舌苔薄白|K47",
		"脉弦细|K48",
		"脉细滑|K49",
		"脉弦滑|K50",
		"脉细|K51",
		"脉滑|K52",
		"发热缓解|K53",
		"咳嗽咯痰|K54",
		"少许咳嗽|K55",
		"咳嗽痰多|K56",
		"咳嗽咽痒|K57",
		"咳嗽少气|K58",
		"已无咳嗽|K59",
		"咳嗽稍好转|K60",
		"咳嗽缓解|K61",
		"咳嗽无痰|K62",
		"少咳痰粘|K63",
		"干咳|K64",
		"偶有干咳|K65",
		"咳嗽加重|K66",
		"咳嗽少痰|K67",
		"偶咳嗽|K68",
		"咳嗽较剧|K69",
		"咳嗽痰少|K70",
		"咯少量血痰|K71",
		"咳嗽痰色白|K72",
		"痰血减少|K73",
		"咳嗽频繁|K74",
		"咯黄白痰|K75",
		"偶咯痰|K76",
		"痰白可咯|K77",
		"痰多色黄|K78",
		"痰少色白|K79",
		"少痰难咯|K80",
		"黄痰难咯|K81",
		"痰血加重|K82",
		"咯黄白色稀痰|K83",
		"白痰|K84",
		"咯痰|K85",
		"仍耳鸣|K86",
		"咳嗽少作|K87",
		"痰黄白|K88",
		"咳嗽好转|K89",
		"咳嗽少|K90",
		"少白痰|K91",
		"咳嗽胸闷|K92",
		"痰多色灰白|K93",
		"痰中带血|K94",
		"痰色黄难咯|K95",
		"偶有痰血|K96",
		"痰难咯|K97",
		"痰浓稠|K98",
		"咯白|K99",
		"痰色白|K100",
		"咯血痰|K101",
		"偶有咳嗽|K102",
		"咳嗽已止|K103",
		"咳嗽反复|K104",
		"咳嗽痰血|K105",
		"咳嗽减少|K106",
		"咳嗽痰白|K107",
		"咯黄色稀痰|K108",
		"咽中有痰|K109",
		"量少色黄|K110",
		"仍倦怠欲眠|K111",
		"咽干|K112",
		"咯黄痰|K113",
		"少许血丝痰|K114",
		"偶咳少痰|K115",
		"痰多色白|K116",
		"偶咳|K117",
		"时有呕吐|K118",
		"咯黄白粘痰|K119",
		"痰减少|K120",
		"痰中血丝|K121",
		"痰粘|K122",
		"少量痰血|K123",
		"近汗多|K124",
		"胸痛|K125",
		"胸闷缓解|K126",
		"胸闷少气|K127",
		"偶胸闷|K128",
		"少许胸闷|K129",
		"胸痛缓解|K130",
		"偶有胸闷|K131",
		"胸闷不适|K132",
		"偶胸痛|K133",
		"夜间胸痛|K134",
		"右侧胸痛|K135",
		"时有胸闷|K136",
		"偶有吞咽困难|K137",
		"心慌心悸|K138",
		"眠差梦多|K139",
		"胸闷胸痛|K140",
		"肩背疼痛|K141",
		"周身酸痛|K142",
		"下肢酸软|K143",
		"下肢水肿|K144",
		"下肢疼痛|K145",
		"心悸缓解|K146",
		"胸部胀闷|K147",
		"气促|K148",
		"少气好转|K149",
		"少气自汗|K150",
		"少气心悸|K151",
		"偶有心悸|K152",
		"时倦怠|K153",
		"少气缓解|K154",
		"少气乏力|K155",
		"困倦乏力|K156",
		"头晕乏力|K157",
		"少气好转|K158",
		"口干咽痛|K159",
		"口干减轻|K160",
		"口干欲呕|K161",
		"口腔溃疡|K162",
		"耳鸣好转|K163",
		"倦怠乏力|K164",
		"倦怠少气|K165",
		"偶有少气|K166",
		"仍气短|K167",
		"便秘|K168",
		"便秘缓解|K169",
		"大便难解|K170",
		"腹泻缓解|K171",
		"小便多|K172",
		"腹泻已止|K173",
		"时腹泻|K174",
		"大便次数多|K175",
		"时便溏|K176",
		"便溏|K177",
		"便溏缓解|K178",
		"便烂|K179",
		"偶有呕吐|K180",
		"大便难排|K181",
		"小便短少|K182",
		"大便尚可|K183",
		"呕吐已止|K184",
		"小便可|K185",
		"大便次多|K186",
		"胃脘不适|K187",
		"胃脘不适缓解|K188",
		"大便时腹痛|K189",
		"夜尿多|K190",
		"腹胀好转|K191",
		"无恶心欲呕|K192",
		"恶心欲呕|K193",
		"泛酸胃痛|K194",
		"大便不畅|K195",
		"尿血|K196",
		"夜尿频|K197",
		"大便可|K198",
		"动则出汗|K199",
		"已无头晕|K200",
		"偶头痛|K201",
		"头晕胸闷好转|K202",
		"头晕缓解|K203",
		"偶有头晕|K204",
		"头晕好转|K205",
		"头晕指麻|K206",
		"时感眩晕|K207",
		"偶指麻|K208",
		"时有头晕|K209",
		"咽痒咳嗽|K211",
		"声嘶好转|K212",
		"咽痒不适|K213",
		"吞咽欠畅|K214",
		"咽痒减轻|K215",
		"吞咽不畅|K216",
		"吞咽困难|K217",
		"吞咽不适|K218",
		"咽痒声嘶|K219",
		"平素焦虑紧张|K220",
		"易倦怠|K221",
		"气短盗汗|K222",
		"胀闷不适|K223",
		"鼻咽不适|K224",
		"乏力缓解|K225",
		"疲倦乏力|K226",
		"腹胀腰酸|K227",
		"腰背痛|K228",
		"骨痛|K229",
		"腰痛|K230",
		"腰椎疼痛|K231",
		"心悸胸痛|K232",
		"眼睛疼痛|K233",
		"胸背痛缓解|K234",
		"隐痛缓解|K235",
		"腰背痛缓解|K236",
		"膝关节痛缓解|K237",
		"偶发头痛|K238",
		"胸肋疼痛|K239",
		"胸背痛|K240",
		"偶牙龈出血|K241",
		"胸闷痛减轻|K242",
		"皮疹瘙痒|K243",
		"少许肤痒|K244",
		"皮疹瘙痒缓解|K245",
		"皮疹瘙痒较重|K246",
		"瘙痒减轻|K247",
		"皮疹轻微|K248",
		"肤痒缓解|K249",
		"皮疹肤痒|K250",
		"生活不能自理|K251",
		"肢体乏力|K252",
		"失语|K253",
		"潮热自汗|K254",
		"反复低热|K255",
		"术口不适|K256",
		"术口隐痛|K257",
		"口苦|K258",
		"心悸气短|K259",
		"嗳气|K260",
		"矢气多|K261"};
	
	public final static String[] cndescriptionkeywords = {
		"纳%good:纳眠可|纳可眠一般|纳可眠稍差|纳可眠好转#ok:纳眠尚可|纳眠一般|纳欠佳眠一般|纳一般眠差|纳眠欠佳|纳改善眠可|纳差眠欠佳|纳眠好转|纳眠稍差#bad:纳差眠可|纳眠差|纳差眠好转|纳差眠改善|纳眠俱差",
		"眠%good:纳眠可|纳差眠可|纳改善眠可#ok:纳眠尚可|纳眠一般|纳可眠一般|纳可眠稍差|纳差眠好转|纳可眠好转|眠差改善|纳差眠改善|纳欠佳眠一般|纳眠欠佳|纳差眠欠佳|纳眠好转|纳眠稍差|#bad:纳可眠差|纳眠差|纳一般眠差|纳眠俱差|眠差梦多",
		"舌%舌质:舌质淡|舌质红|舌质暗红|舌红苔微黄|舌红苔少|舌质紫暗#舌苔:舌苔微黄|舌苔白|舌苔黄|舌苔黄微腻|舌苔黄腻|舌红苔微黄|舌淡苔微黄|舌红苔少|舌苔染色|舌苔薄白",
		"咽%good:无#ok:声嘶好转|吞咽欠畅|咽痒减轻#bad:咽中不适|咽痒咳嗽|咽痒不适|吞咽不畅|吞咽困难|吞咽不适|咽痒声嘶",
		"小便%good:二便调|小便调#ok:小便可#bad:小便次多|尿频|小便多|小便短少|夜尿多|尿血|夜尿频",
		"大便%good:二便调|大便调#ok:二便可|便秘缓解|大便次数多|大便尚可|大便次多|大便不畅|大便可#bad:二便失禁|大便欠通畅|便秘|大便难解|时便溏|便溏|便溏缓解|便烂|大便难排|大便时腹痛|大便不畅",
		"腹%good:腹泻已止|呕吐已止|无恶心欲呕#ok:腹泻缓解|偶有呕吐|胃脘不适缓解|腹胀好转|上腹隐痛缓解#bad:时腹泻|胃脘不适|大便时腹痛|恶心欲呕|泛酸胃痛|恶心呕吐|腹胀闷|干呕|上腹隐痛",
		"皮肤%good:无#ok:少许肤痒|皮疹瘙痒缓解|瘙痒减轻|皮疹轻微|肤痒缓解#bad:皮疹瘙痒|皮疹瘙痒较重|皮疹肤痒",
		"头晕%good:已无头晕#ok:偶头痛|头晕胸闷好转|头晕缓解|偶有头晕|头晕好转|时感眩晕|偶指麻|时有头晕|偶发头痛#bad:头晕指麻",
		"气%good:无#ok:少气好转|少气缓解|偶有少气#bad:气促|少气自汗|少气乏力|头晕乏力|仍气短|气短盗汗|嗳气|矢气多",
		"胸痛%good:无#ok:胸痛缓解|偶胸痛#bad:胸痛|夜间胸痛|右侧胸痛|胸闷胸痛",
		"胸闷%good:无#ok:偶胸闷|少许胸闷|偶有胸闷|胸闷不适|时有胸闷#bad:胸闷缓解|胸闷少气|胸部胀闷|胸闷胸痛",
		"倦怠%good:无#ok:时倦怠|易倦怠|乏力缓解#bad:仍倦怠欲眠|困倦乏力|倦怠乏力|倦怠少气|疲倦乏力",
		"心悸%good:无#ok:心悸缓解|偶有心悸#bad:心慌心悸|少气心悸|平素焦虑紧张|心悸胸痛|心悸气短",
		"咳嗽%good:已无咳嗽|咳嗽已止#ok:少许咳嗽|咳嗽稍好转|咳嗽缓解|偶有干咳|偶咳嗽|偶咯痰|咳嗽少作|咳嗽好转|咳嗽少|偶有痰血|偶有咳嗽|咳嗽减少|偶咳少痰|偶咳#bad:咳嗽咯痰|咳嗽痰多|咳嗽咽痒|咳嗽少气|咳嗽无痰|少咳痰粘|干咳|咳嗽加重|咳嗽少痰|咳嗽较剧|咳嗽痰少|咯少量血痰|咳嗽痰色白|痰血减少|咳嗽频繁|咯黄白痰|痰白可咯|少痰难咯|黄痰难咯|咯黄白色稀痰|咯痰|咳嗽胸闷|痰难咯|咯白痰|咯血痰|咳嗽反复|咳嗽痰血|咳嗽痰白|咯黄色稀痰|咯黄痰|咯黄白粘痰",
		"痰%多:咳嗽痰多|少咳痰粘|痰白可咯|痰多色黄|黄痰难咯|咯黄白色稀痰|痰黄白|痰浓稠|咽中有痰|痰多色白#少:咳嗽无痰|咳嗽少痰|咳嗽痰少|咯少量血痰|痰血减少|痰少色白|少痰难咯|量少色黄|少许血丝痰|偶咳少痰|痰减少|少量痰血#黄色:痰多色黄|黄痰难咯|痰黄白|痰色黄难咯|咯黄色稀痰|量少色黄|咯黄痰|咯黄白粘痰#白色:咳嗽痰色白|咯黄白痰|痰白可咯|痰少色白|白痰|少白痰|痰多色灰白|咯白痰|痰色白|咳嗽痰白|痰多色白#有血痰:咯少量血痰|痰血减少|痰血加重|痰中带血|偶有痰血|咯血痰|咳嗽痰血|少许血丝痰|痰中血丝|少量痰血",
		"脉%描述:脉弦细|脉细滑|脉弦滑|脉细|脉滑"
	};
	public final static String[] cndescriptionkeywords1 = {
		"纳%good:纳眠可|纳可眠一般|纳可眠稍差|纳可眠好转#ok:纳眠尚可|纳眠一般|纳欠佳眠一般|纳一般眠差|纳眠欠佳|纳改善眠可|纳差眠欠佳|纳眠好转|纳眠稍差#bad:纳差眠可|纳眠差|纳差眠好转|纳差眠改善|纳眠俱差",
		"眠%good:纳眠可|纳差眠可|纳改善眠可#ok:纳眠尚可|纳眠一般|纳可眠一般|纳可眠稍差|纳差眠好转|纳可眠好转|眠差改善|纳差眠改善|纳欠佳眠一般|纳眠欠佳|纳差眠欠佳|纳眠好转|纳眠稍差|#bad:纳可眠差|纳眠差|纳一般眠差|纳眠俱差|眠差梦多",
		"舌质%good:舌质淡#ok:舌质红|舌质暗红|舌红苔微黄|舌红苔少|舌质紫暗",
		"舌苔%yellow:舌苔微黄|舌苔黄|舌红苔微黄|舌淡苔微黄|舌红苔少|舌苔染色#white:舌苔薄白|舌苔白#red:舌苔黄微腻|舌苔黄腻",
		"咽%good:无#ok:声嘶好转|吞咽欠畅|咽痒减轻#bad:咽中不适|咽痒咳嗽|咽痒不适|吞咽不畅|吞咽困难|吞咽不适|咽痒声嘶",
		"小便%good:二便调|小便调#ok:小便可#bad:小便次多|尿频|小便多|小便短少|夜尿多|尿血|夜尿频",
		"大便%good:二便调|大便调#ok:二便可|便秘缓解|大便次数多|大便尚可|大便次多|大便不畅|大便可#bad:二便失禁|大便欠通畅|便秘|大便难解|时便溏|便溏|便溏缓解|便烂|大便难排|大便时腹痛|大便不畅",
		"腹%good:腹泻已止|呕吐已止|无恶心欲呕#ok:腹泻缓解|偶有呕吐|胃脘不适缓解|腹胀好转|上腹隐痛缓解#bad:时腹泻|胃脘不适|大便时腹痛|恶心欲呕|泛酸胃痛|恶心呕吐|腹胀闷|干呕|上腹隐痛",
		"皮肤%good:无#ok:少许肤痒|皮疹瘙痒缓解|瘙痒减轻|皮疹轻微|肤痒缓解#bad:皮疹瘙痒|皮疹瘙痒较重|皮疹肤痒",
		"头晕%good:已无头晕#ok:偶头痛|头晕胸闷好转|头晕缓解|偶有头晕|头晕好转|时感眩晕|偶指麻|时有头晕|偶发头痛#bad:头晕指麻",
		"气%good:无#ok:少气好转|少气缓解|偶有少气#bad:气促|少气自汗|少气乏力|头晕乏力|仍气短|气短盗汗|嗳气|矢气多",
		"胸痛%good:无#ok:胸痛缓解|偶胸痛#bad:胸痛|夜间胸痛|右侧胸痛|胸闷胸痛",
		"胸闷%good:无#ok:偶胸闷|少许胸闷|偶有胸闷|胸闷不适|时有胸闷#bad:胸闷缓解|胸闷少气|胸部胀闷|胸闷胸痛",
		"倦怠%good:无#ok:时倦怠|易倦怠|乏力缓解#bad:仍倦怠欲眠|困倦乏力|倦怠乏力|倦怠少气|疲倦乏力",
		"心悸%good:无#ok:心悸缓解|偶有心悸#bad:心慌心悸|少气心悸|平素焦虑紧张|心悸胸痛|心悸气短",
		"咳嗽%good:已无咳嗽|咳嗽已止#ok:少许咳嗽|咳嗽稍好转|咳嗽缓解|偶有干咳|偶咳嗽|偶咯痰|咳嗽少作|咳嗽好转|咳嗽少|偶有痰血|偶有咳嗽|咳嗽减少|偶咳少痰|偶咳#bad:咳嗽咯痰|咳嗽痰多|咳嗽咽痒|咳嗽少气|咳嗽无痰|少咳痰粘|干咳|咳嗽加重|咳嗽少痰|咳嗽较剧|咳嗽痰少|咯少量血痰|咳嗽痰色白|痰血减少|咳嗽频繁|咯黄白痰|痰白可咯|少痰难咯|黄痰难咯|咯黄白色稀痰|咯痰|咳嗽胸闷|痰难咯|咯白痰|咯血痰|咳嗽反复|咳嗽痰血|咳嗽痰白|咯黄色稀痰|咯黄痰|咯黄白粘痰",
		"痰色%good:痰多色黄|黄痰难咯|痰黄白|痰色黄难咯|咯黄色稀痰|量少色黄|咯黄痰|咯黄白粘痰#ok:咳嗽痰色白|咯黄白痰|痰白可咯|痰少色白|白痰|少白痰|痰多色灰白|咯白痰|痰色白|咳嗽痰白|痰多色白#bad:咯少量血痰|痰血减少|痰血加重|痰中带血|偶有痰血|咯血痰|咳嗽痰血|少许血丝痰|痰中血丝|少量痰血",
		"痰量%bad:咳嗽痰多|少咳痰粘|痰白可咯|痰多色黄|黄痰难咯|咯黄白色稀痰|痰黄白|痰浓稠|咽中有痰|痰多色白#ok:咳嗽无痰|咳嗽少痰|咳嗽痰少|咯少量血痰|痰血减少|痰少色白|少痰难咯|量少色黄|少许血丝痰|偶咳少痰|痰减少|少量痰血",
		"脉%weak:脉弦细|脉细#slip:脉弦滑|脉滑#weakslip:脉细滑"
	};
	
	public final static String[] cndescriptionkeywords2 = {
		"纳%good:纳眠可|纳可眠一般|纳可眠稍差|纳可眠好转#ok:纳眠尚可|纳眠一般|纳欠佳眠一般|纳一般眠差|纳眠欠佳|纳改善眠可|纳差眠欠佳|纳眠好转|纳眠稍差#bad:纳差眠可|纳眠差|纳差眠好转|纳差眠改善|纳眠俱差",
		"眠%good:纳眠可|纳差眠可|纳改善眠可#ok:纳眠尚可|纳眠一般|纳可眠一般|纳可眠稍差|纳差眠好转|纳可眠好转|眠差改善|纳差眠改善|纳欠佳眠一般|纳眠欠佳|纳差眠欠佳|纳眠好转|纳眠稍差|#bad:纳可眠差|纳眠差|纳一般眠差|纳眠俱差|眠差梦多",
		"舌质%good:舌质淡#ok:舌质红|舌质暗红|舌红苔微黄|舌红苔少|舌质紫暗",
		"舌苔%yellow:舌苔微黄|舌苔黄|舌红苔微黄|舌淡苔微黄|舌红苔少|舌苔染色#white:舌苔薄白|舌苔白#red:舌苔黄微腻|舌苔黄腻",
		"咽%good:无#ok:声嘶好转|吞咽欠畅|咽痒减轻#bad:咽中不适|咽痒咳嗽|咽痒不适|吞咽不畅|吞咽困难|吞咽不适|咽痒声嘶",
		"小便%good:二便调|小便调#ok:小便可#bad:小便次多|尿频|小便多|小便短少|夜尿多|尿血|夜尿频",
		"大便%good:二便调|大便调#ok:二便可|便秘缓解|大便次数多|大便尚可|大便次多|大便不畅|大便可#bad:二便失禁|大便欠通畅|便秘|大便难解|时便溏|便溏|便溏缓解|便烂|大便难排|大便时腹痛|大便不畅",
		"腹%good:腹泻已止|呕吐已止|无恶心欲呕#ok:腹泻缓解|偶有呕吐|胃脘不适缓解|腹胀好转|上腹隐痛缓解#bad:时腹泻|胃脘不适|大便时腹痛|恶心欲呕|泛酸胃痛|恶心呕吐|腹胀闷|干呕|上腹隐痛",
		"皮肤%good:无#ok:少许肤痒|皮疹瘙痒缓解|瘙痒减轻|皮疹轻微|肤痒缓解#bad:皮疹瘙痒|皮疹瘙痒较重|皮疹肤痒",
		"头晕%good:已无头晕#ok:偶头痛|头晕胸闷好转|头晕缓解|偶有头晕|头晕好转|时感眩晕|偶指麻|时有头晕|偶发头痛#bad:头晕指麻",
		"气%good:无#ok:少气好转|少气缓解|偶有少气#bad:气促|少气自汗|少气乏力|头晕乏力|仍气短|气短盗汗|嗳气|矢气多",
		"胸痛%good:无#ok:胸痛缓解|偶胸痛#bad:胸痛|夜间胸痛|右侧胸痛|胸闷胸痛",
		"胸闷%good:无#ok:偶胸闷|少许胸闷|偶有胸闷|胸闷不适|时有胸闷#bad:胸闷缓解|胸闷少气|胸部胀闷|胸闷胸痛",
		"倦怠%good:无#ok:时倦怠|易倦怠|乏力缓解#bad:仍倦怠欲眠|困倦乏力|倦怠乏力|倦怠少气|疲倦乏力",
		"心悸%good:无#ok:心悸缓解|偶有心悸#bad:心慌心悸|少气心悸|平素焦虑紧张|心悸胸痛|心悸气短",
		"咳嗽%good:已无咳嗽|咳嗽已止#ok:少许咳嗽|咳嗽稍好转|咳嗽缓解|偶有干咳|偶咳嗽|偶咯痰|咳嗽少作|咳嗽好转|咳嗽少|偶有痰血|偶有咳嗽|咳嗽减少|偶咳少痰|偶咳#bad:咳嗽咯痰|咳嗽痰多|咳嗽咽痒|咳嗽少气|咳嗽无痰|少咳痰粘|干咳|咳嗽加重|咳嗽少痰|咳嗽较剧|咳嗽痰少|咯少量血痰|咳嗽痰色白|痰血减少|咳嗽频繁|咯黄白痰|痰白可咯|少痰难咯|黄痰难咯|咯黄白色稀痰|咯痰|咳嗽胸闷|痰难咯|咯白痰|咯血痰|咳嗽反复|咳嗽痰血|咳嗽痰白|咯黄色稀痰|咯黄痰|咯黄白粘痰",
		"痰色%good:痰多色黄|黄痰难咯|痰黄白|痰色黄难咯|咯黄色稀痰|量少色黄|咯黄痰|咯黄白粘痰#ok:咳嗽痰色白|咯黄白痰|痰白可咯|痰少色白|白痰|少白痰|痰多色灰白|咯白痰|痰色白|咳嗽痰白|痰多色白#bad:咯少量血痰|痰血减少|痰血加重|痰中带血|偶有痰血|咯血痰|咳嗽痰血|少许血丝痰|痰中血丝|少量痰血",
		"痰量%bad:咳嗽痰多|少咳痰粘|痰白可咯|痰多色黄|黄痰难咯|咯黄白色稀痰|痰黄白|痰浓稠|咽中有痰|痰多色白#ok:咳嗽无痰|咳嗽少痰|咳嗽痰少|咯少量血痰|痰血减少|痰少色白|少痰难咯|量少色黄|少许血丝痰|偶咳少痰|痰减少|少量痰血",
		"脉%weak:脉弦细|脉细#slip:脉弦滑|脉滑#weakslip:脉细滑"
	};
	
	public final static String[] descriptionconvert = {
		"hanre%hanwu:寒无#hanqing:寒轻#hanzhong:寒重#rewu:热无#reqing:热轻#rezhong:热重#hanre:寒热往来",
		"sweat%sweat:汗（有）#nosweat:汗（无）#zihan:自汗#daohan:盗汗#dahan:大汗",
		"xonglei%no:胸肋痛（无）#ok:胸肋痛（轻）#bad:胸肋痛（中）#worse:胸肋痛（重）",
		"futong%no:腹痛（无）#ok:腹痛（轻）#bad:腹痛（中）#worse:腹痛（重）",
		"defecate%ok:大便（轻）#bad:大便（中）#worse:大便（重）",
		"urinate%ok:小便尚可#bad:小便次多#worse:尿频#blood:尿血",
		"tonguecolor%ok:淡红正常#white:淡白#red:红色#jiang:降色#purple:紫色#cyan:青色#blue:蓝色",
		"coatedtongue%white:白苔#yellow:黄苔#purple:紫苔#black:黑（灰）苔#nitai:腻苔#houtai:厚苔",
		"sputumamount%ok:痰量（正常）#little:痰少#much:痰多",
		"sputumcolor%yellow:黄#white:白#redlittle:红血痰（少）#redmuch:红血痰（多）#redmore:红血痰（特多）",
		"sleep%ok:眠正常#bad:失眠（轻）#worse:失眠（中）#worst:失眠（重）#somnolence:嗜睡",
		"na%ok:纳正常#bad:纳差#anorexia:厌食#worse:食欲减退",
		"energy%ok:气力正常#bad:气力差#worse:气力（特差）",
		"pulse%float:脉浮#sink:脉沉#slim:脉细#rough:脉粗#late:脉迟#number:脉数#chord:脉弦#slide:脉滑",
		"thirst%ok:口不渴#bad:喝不多饮#worse:口渴多饮",
		"taste%light:口淡#acid:泛酸#bitter:口苦",
		"cough%ok:咳嗽正常#bad:咳嗽（轻）#worse:咳嗽（中）#worst:咳嗽（重）"
	};
	
//	public static String[] descriptionKeywords = {
//		"timestatus%shuqian:术前#shuhou:术后#zhiliaozhong:放疗中#zhiliaohou:放疗后#hualiaozhong:化疗中#hualiaohou:化疗后#fenzi:分子靶向药物#mianyi:免疫治疗",
//		"hanre%hanwu:寒无#hanqing:寒轻#hanzhong:寒重#rewu:热无#reqing:热轻#rezhong:热重#hanre:寒热往来",
//		"sweat%sweat:有#nosweat:无#zihan:自汗#daohan:盗汗#dahan:大汗",
//		"xonglei%noxonglei:无#okxonglei:轻度胸肋痛|胸痛缓解|偶胸痛#badxonglei:胸肋痛#worsexonglei:重度胸肋痛|胸痛|夜间胸痛|右侧胸痛|胸闷胸痛",
//		"futong%nofutong:无#okfutong:轻度腹痛#badfutong:腹痛#worsefutong:重度腹痛（重）",
//		"defecate%defaultdefecate:无便秘#okdefecate:二便可|便秘缓解|大便次数多|大便尚可|大便次多|大便不畅|大便可|大便欠通畅#baddefecate:大便（中）#worsedefecate:二便失禁|大便欠通畅|大便难解|时便溏|便溏|便溏缓解|便烂|大便难排|大便时腹痛|大便不畅",
//		"xiexie%ok:无#xiexie:泄泻",
//		"urinate%okurinate:二便调|小便调#badurinate:小便次多#worseurinate:尿频#bloodurinate:尿血",
//		"tonguecolor%oktonguecolor:淡红正常|舌质淡#whitetonguecolor:淡白#redtonguecolor:舌质红|舌质暗红|舌红苔微黄|舌红苔少#jiangtonguecolor:降色#purpletonguecolor:舌质紫暗#cyantonguecolor:青色#bluetonguecolor:蓝色",
//		"coatedtongue%whitecoatedtongue:舌苔薄白|舌苔白#yellowcoatedtongue:舌苔微黄|舌苔黄|舌红苔微黄|舌淡苔微黄|舌红苔少|舌苔染色#purplecoatedtongue:紫苔#blackcoatedtongue:黑（灰）苔#nitaicoatedtongue:舌苔黄微腻|舌苔黄腻#houtaicoatedtongue:厚苔",
//		"sputumamount%oksputumamount:无#littlesputumamount:咳嗽无痰|咳嗽少痰|咳嗽痰少|咯少量血痰|痰血减少|痰少色白|少痰难咯|量少色黄|少许血丝痰|偶咳少痰|痰减少|少量痰血#muchsputumamount:咳嗽痰多|少咳痰粘|痰白可咯|痰多色黄|黄痰难咯|咯黄白色稀痰|痰黄白|痰浓稠|咽中有痰|痰多色白",
//		"sputumcolor%defalutsputumcolor:痰色正常#yellowsputumcolor:痰多色黄|黄痰难咯|痰黄白|痰色黄难咯|咯黄色稀痰|量少色黄|咯黄痰|咯黄白粘痰#whitesputumcolor:咳嗽痰色白|咯黄白痰|痰白可咯|痰少色白|白痰|少白痰|痰多色灰白|咯白痰|痰色白|咳嗽痰白|痰多色白#redlittlesputumcolor:少许血丝痰|痰中血丝|少量痰血#redmuchsputumcolor:咯少量血痰|痰血减少|痰中带血|偶有痰血|咯血痰|咳嗽痰血#redmoresputumcolor:痰血加重",
//		"sleep%oksleep:纳眠可|纳差眠可|纳改善眠可#badsleep:纳眠尚可|纳眠一般|纳可眠一般|纳可眠稍差|纳差眠好转|纳可眠好转|眠差改善|纳差眠改善|纳欠佳眠一般|纳眠欠佳|纳差眠欠佳|纳眠好转|纳眠稍差#worsesleep:纳可眠差|纳眠差|纳一般眠差|纳眠俱差|眠差梦多#worstsleep:失眠#somnolencesleep:嗜睡",
//		"na%okna:纳眠可|纳可眠一般|纳可眠稍差|纳可眠好转#badna:纳眠尚可|纳眠一般|纳欠佳眠一般|纳一般眠差|纳眠欠佳|纳改善眠可|纳差眠欠佳|纳眠好转|纳眠稍差|纳差眠可|纳眠差|纳差眠好转|纳差眠改善|纳眠俱差#anorexiana:厌食#worsena:食欲减退",
//		"energy%okenergy:无#badenergy:少气好转|少气缓解|偶有少气#worseenergy:气促|少气自汗|少气乏力|头晕乏力|仍气短|气短盗汗|嗳气|矢气多",
//		"pulse%floatpulse:脉浮#sinkpulse:脉沉#slimpulse:脉细|脉弦细#roughpulse:脉粗#latepulse:脉迟#numberpulse:脉数#chordpulse:脉弦|脉弦细|脉弦滑#slidepulse:脉滑|脉弦滑",
//		"thirst%okthirst:口不渴#badthirst:喝不多饮#worsethirst:口渴多饮",
//		"taste%lighttaste:口淡#acidtaste:泛酸#bittertaste:口苦",
//		"cough%okcough:正常|已无咳嗽|咳嗽已止#badcough:少许咳嗽|咳嗽稍好转|咳嗽缓解|偶有干咳|偶咳嗽|偶咯痰|咳嗽少作|咳嗽好转|咳嗽少|偶有痰血|偶有咳嗽|咳嗽减少|偶咳少痰|偶咳#worsecough:咳嗽咯痰|咳嗽痰多|咳嗽咽痒|咳嗽少气|咳嗽无痰|少咳痰粘|干咳|咳嗽少痰|咳嗽痰少|咯少量血痰|咳嗽痰色白|痰血减少|咯黄白痰|痰白可咯|少痰难咯|黄痰难咯|咯黄白色稀痰|咯痰|咳嗽胸闷|痰难咯|咯白痰|咯血痰|咳嗽痰白|咯黄色稀痰|咯黄痰|咯黄白粘痰#worstcough:咳嗽频繁|咳嗽反复|咳嗽痰血|咳嗽加重|咳嗽较剧",
//		"yaotong%yaotong:腰痛",
//		"wantong%wantong:脘痛",
//		"toutong%toutong:头痛",
//		"touyun%touyun:头晕",
//		"xinji%xinji:心悸",
//		"xiongmen%xiongmen:胸闷",
//		"fuzhang%fuzhang:腹胀",
//		"wanzhang%wanzhang:脘胀",
//		"shenzhong%shenzhong:身重",
//		"erming%erming:耳鸣",
//		"muxuan%muxuan:目眩",
//		"mamu%mamu:麻木",
//	};
	
	/**
	 * the description keywords tables
	 */
	public final static String[] descriptionKeywords = {
			

			"sputumamount%oksputumamount:咳嗽无痰|无痰#littlesputumamount:现咳嗽稀痰，|，痰白可咯减少，|有痰难咳，|咳嗽痰多缓解，|，有痰，|现咳嗽痰多缓解，|，痰少|现少咳痰血|，有痰，|咳嗽少痰|咳嗽痰少|咯少量血痰|痰血减少|痰少色白|少痰难咯|量少色黄|少许血丝痰|偶咳少痰|痰减少|少量痰血#muchsputumamount:现痰多难咯，|现咳嗽咯痰，|咽痒咳嗽痰粘，|现咳嗽痰难咯，|，咳嗽咯痰，|现少咳有痰色黄|咳嗽痰多|少咳痰粘|痰白可咯|痰多色黄|黄痰难咯|咯黄白色稀痰|痰黄白|痰浓稠|咽中有痰|痰多色白",

			"sputumcolor%defalutsputumcolor:痰色正常|已无痰血#yellowsputumcolor:痰多色黄|黄痰难咯|痰黄白|痰色黄难咯|咯黄色稀痰|量少色黄|咯黄痰|咯黄白粘痰|现少咳有痰色黄#whitesputumcolor:现少咳痰白，|咳嗽痰色白|咯黄白痰|痰白可咯|痰少色白|白痰|少白痰|痰多色灰白|咯白痰|痰色白|咳嗽痰白|痰多色白#redlittlesputumcolor:痰血减少|，痰中带血，|咳嗽咯痰带血丝，|咯血减少，|痰中带血减轻|少许血丝痰|痰中血丝|少量痰血|偶有痰血|现咳嗽痰血缓解|现咳嗽痰血少，#redmuchsputumcolor:现咳嗽咯痰血，|咯少量血痰|痰中带血，|咯血痰|，血痰，|现仍咳嗽血痰#redmoresputumcolor:痰血加重",

			"cough%okcough:现无咳嗽咯痰，|咳嗽正常|已无咳嗽|咳嗽已止#badcough:。现偶咳嗽，|现少咳咯白痰，现咽痒少咳，|现少咳痰白，|现干咳减轻|现咳嗽痰血少，|咳嗽少作，|现咳嗽痰多缓解，|现少咳痰血|现偶有干咳|，少咳|现少咳有痰色黄|少许咳嗽|咳嗽稍好转|咳嗽缓解|偶有干咳|偶咳嗽|偶咯痰|咳嗽少作|咳嗽好转|咳嗽少|偶有痰血|偶有咳嗽|咳嗽减少|偶咳少痰|偶咳#worsecough:：咳嗽，|现咳嗽稀痰，|咽痒咳嗽痰粘，|，咽痒咳嗽，|现咽痒咳嗽，|，咳嗽咯痰，|现咳嗽，|，咳嗽，|现仍咳嗽血痰|，干咳|，饮水呛咳|，咽痒咳嗽|时咳嗽咯痰|咳嗽痰多|咳嗽咽痒|咳嗽少气|咳嗽无痰|少咳痰粘|咳嗽痰少|咯少量血痰|咳嗽痰色白|痰血减少|咯黄白痰|痰白可咯|少痰难咯|黄痰难咯|咯黄白色稀痰|咯痰|咳嗽胸闷|痰难咯|咯白痰|咯血痰|咳嗽痰白|咯黄色稀痰|咯黄痰|咯黄白粘痰#worstcough:咳嗽频繁|咳嗽反复|咳嗽痰血|咳嗽加重|咳嗽较剧",
			
			"sleep%oksleep:纳寐可|纳眠可|纳差眠可|纳改善眠可#badsleep:纳可眠改善，|纳眠尚可|纳眠一般|纳可眠一般|纳可眠稍差|纳差眠好转|纳可眠好转|眠差改善|纳差眠改善|纳欠佳眠一般|纳眠欠佳|纳差眠欠佳|纳眠好转|纳眠稍差#worsesleep:纳可眠差|纳眠差|纳一般眠差|纳眠俱差|眠差梦多#worstsleep:失眠#somnolencesleep:嗜睡",

			"na%okna:已无恶心欲呕，|纳寐可|纳眠可|纳可眠一般|纳可眠稍差|纳可眠好转#badna:纳眠尚可|纳眠一般|纳欠佳眠一般|纳一般眠差|纳眠欠佳|纳改善眠可|纳差眠欠佳|纳眠好转|纳眠稍差|纳差眠可|纳眠差|纳差眠好转|纳差眠改善|纳眠俱差#anorexiana:厌食|，恶心欲呕|，时有呕吐|，偶有呕吐#worsena:食欲减退",

			"xonglei%noxonglei:无胸肋痛#okxonglei:左胸轻痛，|胸部疼痛缓解，|咳嗽胸痛减少，|夜间胸痛缓解，|右胸背部隐痛，|，胸痛缓解，|左胸隐痛，|胸部隐痛，|，少许胸痛，|轻度胸肋痛|胸痛缓解|偶胸痛|稍有疼痛|偶有胸痛|胸胁不适轻微|现仍左胸胁不适|，胸闷痛减轻，|现胸背隐痛，#badxonglei:夜间胸痛|现左胸闷不适，|，胸痛，|胸背部疼痛，|现左胸胁不适，|现左胁肋疼痛不适|现左胸疼痛，|现右侧胸背痛，|现左胸背疼痛|现胸背痛|、颈、胸部疼痛|胸肋痛|现头、颈、胸部疼痛｜。头痛骨痛|胸背痛右侧胸痛|胸闷胸痛#worsexonglei:重度胸肋痛|全身骨痛",

			"tonguecolor%oktonguecolor:淡红正常|舌质淡#whitetonguecolor:淡白#redtonguecolor:舌质红|舌质暗红|舌红苔微黄|舌红苔少#jiangtonguecolor:降色#purpletonguecolor:舌质紫暗#cyantonguecolor:青色#bluetonguecolor:蓝色",

			"coatedtongue%whitecoatedtongue:舌苔薄白|舌苔白|舌苔白腻#yellowcoatedtongue:舌苔微黄|舌苔黄|舌红苔微黄|舌淡苔微黄|舌红苔少|舌苔染色#purplecoatedtongue:紫苔#blackcoatedtongue:黑（灰）苔#nitaicoatedtongue:舌苔黄微腻|舌苔黄腻#houtaicoatedtongue:厚苔",

			"defecate%defaultdefecate:二便可|无便秘#okdefecate:便秘缓解|大便次数多|大便尚可|大便次多|大便不畅|大便可|大便欠通畅#baddefecate:大便难排|大便欠通畅|，便秘，|，便秘。#worsedefecate:二便失禁|大便难解|时便溏|，便溏，|便溏缓解|便烂|大便时腹痛|大便不畅",

			"xiexie%ok:，腹泻已止，|无腹泻#xiexie:泻泄|，腹泻（|因腹泻严重|，腹泻，|因腹泻、|，腹泻好转，|时腹泻，|时有腹泻|腹泻缓解|近腹泻，|皮疹腹泻|腹泻减少|，腹泻。|腹泻轻微|、腹泻，",

			"urinate%okurinate:二便调|小便调#badurinate:小便次多|小便量少|夜尿多缓解|，夜尿减少#worseurinate:尿频|二便失禁|，夜尿多|现夜尿多，#bloodurinate:尿血",

			"energy%okenergy:气力正常#badenergy:现少气缓解，|声嘶气促缓解，｜少气好转|少气缓解|偶有少气|活动后气促#worseenergy:声嘶气促缓解，|现仍倦怠乏力|现肢体乏力，|倦怠乏力，|现倦怠乏力，|下肢乏力，|近倦怠乏力|，气促，|乏力，|，少气，|现心悸气短，|：气短腰酸，|现咳嗽少气，|现少气，|现静息下气促，|现少气头晕|现倦怠|现倦怠乏力，|现咳嗽少气|，少气心悸|，胸闷气促，|，困倦乏力，|：倦怠|现乏力倦怠|现疲倦|现气促|少气自汗|少气乏力|现头晕乏力|仍气短|气短盗汗|嗳气|矢气多|现倦怠乏力|现气短|现咳嗽少气|乏力，|，倦怠，",

			"pulse%floatpulse:脉浮#sinkpulse:脉沉#slimpulse:脉细|脉弦细|脉细滑#roughpulse:脉粗#latepulse:脉迟#numberpulse:脉数#chordpulse:脉弦|脉弦细|脉弦滑#slidepulse:脉滑|脉弦滑|脉细滑",

			"shijianzhuangtai%shuqian:术前#shuhou:术后#zhiliaozhong:放疗中#zhiliaohou:放疗后#hualiaozhong:化疗中#hualiaohou:化疗后#fenzi:分子靶向药物#mianyi:免疫治疗",

			"hanre%hanwu:寒无#hanqing:寒轻#hanzhong:寒重#rewu:热无#reqing:热轻#rezhong:热重#hanre:寒热往来",

			"sweat%sweat:有汗|汗多，|现汗仍多#nosweat:无汗#zihan:，少气自汗#daohan:盗汗#dahan:大汗",

			"futong%nofutong:无腹痛#okfutong:轻度腹痛#badfutong:大便时腹痛|现便时腹痛|腹痛#worsefutong:重度腹痛（重）",

			"thirst%okthirst:口不渴#badthirst:喝不多饮#worsethirst:口渴多饮|，口干，|仍腰酸口干|现口干，|，夜晚口干|，口干咽痛，",

			"taste%lighttaste:口淡#acidtaste:泛酸#bittertaste:，口苦，",

			"yaotong%yaotong:腰痛|，腰酸痛，|腰骶酸痛|现腰痛|仍腰酸口干|，腰椎疼痛｜，腰酸，",

			"wantong%wantong:脘痛",

			"toutong%toutong:现头痛| 头痛|，偶发头痛|现头、颈、胸部疼痛｜。头痛骨痛|，头晕头痛|头痛骨痛，",

			"touyun%touyun:现偶有头晕|现头晕乏力|，头晕头痛",

			"xinji%xinji:现心悸|，少气心悸",

			"xiongmen%xiongmen:，胸闷|现胸闷，",

			"fuzhang%fuzhang:腹胀",

			"wanzhang%wanzhang:脘胀",

			"shenzhong%shenzhong:身重",

			"erming%erming:耳鸣",

			"muxuan%muxuan:目眩",

			"mamu%mamu:麻木|，时指麻，",
		};
	
	public static String[] descriptionKeywords1 = {
			// Main description keywords
			"痰量%0:咳嗽无痰|无痰#1:现咳嗽稀痰，|，痰白可咯减少，|有痰难咳，|咳嗽痰多缓解，|，有痰，|现咳嗽痰多缓解，|，痰少|现少咳痰血|，有痰，|咳嗽少痰|咳嗽痰少|咯少量血痰|痰血减少|痰少色白|少痰难咯|量少色黄|少许血丝痰|偶咳少痰|痰减少|少量痰血"
					+ "#2:现痰多难咯，|现咳嗽咯痰，|咽痒咳嗽痰粘，|现咳嗽痰难咯，|，咳嗽咯痰，|现少咳有痰色黄|咳嗽痰多|少咳痰粘|痰白可咯|痰多色黄|黄痰难咯|咯黄白色稀痰|痰黄白|痰浓稠|咽中有痰|痰多色白",
			
			"痰色%0:痰色正常|已无痰血#1:痰多色黄|黄痰难咯|痰黄白|痰色黄难咯|咯黄色稀痰|量少色黄|咯黄痰|咯黄白粘痰|现少咳有痰色黄"
					+ "#2:现少咳痰白，|咳嗽痰色白|咯黄白痰|痰白可咯|痰少色白|白痰|少白痰|痰多色灰白|咯白痰|痰色白|咳嗽痰白|痰多色白",
							
			"血痰%0:无血痰#1:痰血减少|咳嗽咯痰带血丝，|咯血减少，|痰中带血减轻|少许血丝痰|痰中血丝|少量痰血|偶有痰血|现咳嗽痰血缓解|现咳嗽痰血少，"
					+ "#2:现咳嗽咯痰血，|咯少量血痰|痰中带血，|咯血痰|，血痰，|现仍咳嗽血痰"
					+ "#3:痰血加重",
					
			"咳嗽%0:现无咳嗽咯痰，|咳嗽正常|已无咳嗽|咳嗽已止#1:现咳嗽痰血减轻，|现咳嗽痰血少作，|现少咳咯白痰，|现咽痒少咳，|现少咳痰白，|现干咳减轻|现咳嗽痰血少，|咳嗽少作，|现咳嗽痰多缓解，|现少咳痰血|现偶有干咳|，少咳|现少咳有痰色黄|少许咳嗽|咳嗽稍好转|咳嗽缓解|偶有干咳|偶咳嗽|偶咯痰|咳嗽少作|咳嗽好转|咳嗽少|偶有痰血|偶有咳嗽|咳嗽减少|偶咳少痰|偶咳|。现偶咳嗽，"
					+ "#2:：咳嗽，|现咳嗽稀痰，|咽痒咳嗽痰粘，|，咽痒咳嗽，|现咽痒咳嗽，|，咳嗽咯痰，|现咳嗽，|，咳嗽，|现仍咳嗽血痰|，干咳|，饮水呛咳|，咽痒咳嗽|时咳嗽咯痰|咳嗽痰多|咳嗽咽痒|咳嗽少气|咳嗽无痰|少咳痰粘|咳嗽痰少|咯少量血痰|咳嗽痰色白|痰血减少|咯黄白痰|痰白可咯|少痰难咯|黄痰难咯|咯黄白色稀痰|咳嗽胸闷|痰难咯|咯白痰|咯血痰|咳嗽痰白|咯黄色稀痰|咯黄痰|咯黄白粘痰"
					+ "#3:咳嗽频繁|咳嗽反复|咳嗽痰血，|现咳嗽痰血加重，|咳嗽加重|咳嗽较剧",
					
			"眠%0:纳寐可|纳眠可|纳差眠可|纳改善眠可#1:纳可眠改善，|纳眠尚可|纳眠一般|纳可眠一般|纳可眠稍差|纳差眠好转|纳可眠好转|眠差改善|纳差眠改善|纳欠佳眠一般|纳眠欠佳|纳差眠欠佳|纳眠好转|纳眠稍差#2:纳可眠差|纳眠差|纳一般眠差|纳眠俱差|眠差梦多"
					+ "#3:失眠#4:嗜睡",
			
			"纳%0:已无恶心欲呕，|纳寐可|纳眠可|纳可眠一般|纳可眠稍差|纳可眠好转#1:纳眠尚可|纳眠一般|纳欠佳眠一般|纳一般眠差|纳眠欠佳|纳改善眠可|纳差眠欠佳|纳眠好转|纳眠稍差|纳差眠可|纳眠差|纳差眠好转|纳差眠改善|纳眠俱差#2:厌食|，恶心欲呕|，时有呕吐|，偶有呕吐#3:食欲减退",
					
			"胸肋痛%0:无胸肋痛#1:左胸轻痛，|胸部疼痛缓解，|咳嗽胸痛减少，|夜间胸痛缓解，|右胸背部隐痛，|，胸痛缓解，|左胸隐痛，|胸部隐痛，|，少许胸痛，|轻度胸肋痛|胸痛缓解|偶胸痛|稍有疼痛|偶有胸痛|胸胁不适轻微|现仍左胸胁不适|，胸闷痛减轻，|现胸背隐痛，"
					+ "#2:夜间胸痛|现左胸闷不适，|，胸痛，|胸背部疼痛，|现左胸胁不适，|现左胁肋疼痛不适|现左胸疼痛，|现右侧胸背痛，|现左胸背疼痛|现胸背痛|、颈、胸部疼痛|胸肋痛|现头、颈、胸部疼痛｜。头痛骨痛|胸背痛右侧胸痛|胸闷胸痛"
					+ "#3:重度胸肋痛|全身骨痛",
			
			"舌色%0:淡红正常|舌质淡#1:淡白#2:舌质红|舌质暗红|舌红苔微黄|舌红苔少#3:降色#4:舌质紫暗#5:青色#6:蓝色",
					
			"舌苔%0:无舌苔#1:舌苔薄白|舌苔白|舌苔白腻#2:舌苔微黄|舌苔黄|舌红苔微黄|舌淡苔微黄|舌红苔少|舌苔染色#3:紫苔#4:黑（灰）苔#5:舌苔黄微腻|舌苔黄腻#6:厚苔",
			
			"大便%0:无便秘#1:便秘缓解|大便次数多|大便尚可|大便次多|大便不畅|大便可|大便欠通畅#2:大便难排|大便欠通畅|，便秘，|，便秘。"
					+ "#3:二便失禁|大便难解|时便溏|，便溏，|便溏缓解|便烂|大便时腹痛|大便不畅#4:，便血，",
					
			"腹泻%0:无腹泻#1:泻泄|，腹泻（|因腹泻严重|，腹泻，|因腹泻、|，腹泻好转，|时腹泻，|时有腹泻|腹泻缓解|近腹泻，|皮疹腹泻|腹泻减少|，腹泻。|腹泻轻微|、腹泻，",
					
			"小便%0:二便调|小便调#1:小便次多|小便量少|夜尿多缓解|，夜尿减少#2:尿频|二便失禁|，夜尿多|现夜尿多，#3:尿血",
			
			"气力%0:气力正常#1:现少气缓解，|声嘶气促缓解，｜少气好转|少气缓解|偶有少气|活动后气促"
					+ "#2:声嘶气促缓解，|现仍倦怠乏力|现肢体乏力，|倦怠乏力，|现倦怠乏力，|下肢乏力，|近倦怠乏力|，气促，|乏力，|，少气，|现心悸气短，|：气短腰酸，|现咳嗽少气，|现少气，|现静息下气促，|现少气头晕|现倦怠|现倦怠乏力，|现咳嗽少气|，少气心悸|，胸闷气促，|，困倦乏力，|：倦怠|现乏力倦怠|现疲倦|现气促|少气自汗|少气乏力|现头晕乏力|仍气短|气短盗汗|嗳气|矢气多|现倦怠乏力|现气短|现咳嗽少气|乏力，|，倦怠，",
			// Second description keywords
			"脉浮%0:无脉浮#1:脉浮",
					
			"脉沉%0:无脉沉#1:脉沉",
			 		
			"脉细%0:无脉细#1:脉细|脉弦细|脉细滑",
			 		
			"脉粗%0:无脉粗#1:脉粗",
			 		
			"脉迟%0:无脉迟#1:脉迟",
			 		
			"脉数%0:无脉数#1:脉数",
					
			"脉弦%0:无脉弦#1:脉弦|脉弦细|脉弦滑",
			 		
			"脉滑%0:无脉滑#1:脉滑|脉弦滑|脉细滑",
			// The last description keywords	
			"时间状态%1:术前#2:术后#3:放疗中#4:放疗后#5:化疗中#6:化疗后#7:分子靶向药物#8:免疫治疗",
			
		 	"寒%0:寒无#1:寒轻#2:寒重",
		 	
			"热%0:热无#1:热轻#2:热重",
			
			"寒热往来%0:无寒热往来#1:寒热往来",
			
			"汗%0:无汗#1:有汗|汗多，|现汗仍多#2:，少气自汗#3:盗汗#4:大汗",
			
			"腹痛%0:无腹痛#1:轻度腹痛#2:现便时腹痛|腹痛#3:重度腹痛（重）",
			
			"口渴%0:口不渴#1:喝不多饮#2:口渴多饮|，口干，|仍腰酸口干|现口干，|，夜晚口干|，口干咽痛，",
			
			"口味%0:无口味#1:口淡#2:泛酸#3:，口苦，",
			
			"腰痛%0:无腰痛#1:腰痛|，腰酸痛，|腰骶酸痛|现腰痛|仍腰酸口干|，腰椎疼痛",
			
			"脘痛%0:无脘痛#1:脘痛",
			
			"头痛%0:无头痛#1:现头痛| 头痛|，偶发头痛|现头、颈、胸部疼痛｜。头痛骨痛|，头晕头痛|头痛骨痛，",
			
			"头晕%0:无头晕#1:现偶有头晕|现头晕乏力|，头晕头痛",
			
			"心悸%0:无心悸#1:现心悸|，少气心悸",
			
			"胸闷%0:无胸闷#1:，胸闷|现胸闷，",
			
			"腹胀%0:无腹胀#1:腹胀",
			
			"脘胀%0:无脘胀#1:脘胀",
			
			"身重%0:无身重#1:身重",
			
			"耳鸣%0:无耳鸣#1:耳鸣",
			
			"目眩%0:无目眩#1:目眩",
			
			"麻木%0:无麻木#1:麻木|，时指麻，"
	};
	
	/**
	 * The input keywords description
	 */
	public final static String[] descriptionStrings = {
			"cmtreat:单纯中医药治疗",
			"shuqian:术前",
			"shuhou:术后",
			"zhiliaozhong:放疗中",
			"zhiliaohou:放疗后",
			"hualiaozhong:化疗中",
			"hualiaohou:化疗后",
			"fenzi:分子靶向药物",
			"mianyi:免疫治疗",
		"hanwu:寒（无）",
		"hanqing:寒（轻）",
		"hanzhong:寒（重）",
		"rewu:热（无）",
		"reqing:热（轻）",
		"rezhong:热（重）",
		"hanre:寒热往来",
		"sweat:有汗",
		"nosweat:无汗",
		"zihan:自汗",
		"daohan:盗汗",
		"dahan:大汗",
		"noxionglei:胸肋痛（无）",
		"okxionglei:胸肋痛（轻）",
		"badxionglei:胸肋痛（中）",
		"worsexionglei:胸肋痛（重）",
		"nofutong:痛（无）",
		"okfutong:腹痛（轻）",
		"badfutong:腹痛（中）",
		"worsefutong:腹痛（重）",
		"yaotong:腰痛",
		"wantong:脘痛",
		"toutong:头痛",
		"touyun:头晕",
		"xinji:心悸",
		"xiongmen:胸闷",
		"fuzhang:腹胀",
		"wanzhang:脘胀",
		"shenzhong:身重",
		"erming:耳鸣",
		"muxuan:目眩",
		"mamu:麻木",
		"defaultdefecate:便秘（无）",
		"okdefecate:便秘（轻）",
		"baddefecate:便秘（中）",
		"worsedefecate:便秘（重）",
		"blooddefecate:便血",
		"xiexie:腹泻",
		"okurinate:小便正常",
		"badurinate:小便次多",
		"worseurinate:尿频",
		"bloodurinate:尿血",
		"oktonguecolor:舌质淡红正常",
		"whitetonguecolor:舌质淡白",
		"redtonguecolor:舌质红色",
		"jiangtonguecolor:舌质降色",
		"purpletonguecolor:舌质紫色",
		"cyantonguecolor:舌质青色",
		"bluetonguecolor:舌质蓝色",
		"whitecoatedtongue:舌苔白（正常）",
		"yellowcoatedtongue:舌苔黄",
		"purplecoatedtongue:舌苔紫",
		"blackcoatedtongue:黑（灰）苔",
		"nitaicoatedtongue:腻苔",
		"houtaicoatedtongue:厚苔",
		"oksputumamount:痰量正常",
		"littlesputumamount:痰量少",
		"muchsputumamount:痰量多",
		"yellowsputumcolor:痰黄",
		"whitesputumcolor:痰白",
		"redlittlesputumcolor:红血痰（少）",
		"redmuchsputumcolor:红血痰（多）",
		"redmoresputumcolor:红血痰（特多）",
		"oksleep:睡眠正常",
		"badsleep:失眠（轻）",
		"worsesleep:失眠（中）",
		"worstsleep:失眠（重）",
		"somnolencesleep:嗜睡",
		"okna:纳正常",
		"badna:纳差",
		"anorexiana:厌食",
		"worsena:食欲减退",
		"okenergy:气力正常",
		"badenergy:气力差",
		"worseenergy:气力特差",
		"floatpulse:脉浮",
		"sinkpulse:脉沉",
		"slimpulse:脉细",
		"roughpulse:脉粗",
		"latepulse:脉迟",
		"numberpulse:脉数",
		"chordpulse:脉弦",
		"slidepulse:脉滑",
		"okthirst:口不渴",
		"badthirst:喝不多饮",
		"worsethirst:口渴多饮",
		"lighttaste:口淡",
		"acidtaste:泛酸",
		"bittertaste:口苦",
		"okcough:咳嗽正常",
		"badcough:咳嗽轻",
		"worsecough:咳嗽中",
		"worstcough:咳嗽重"
	};
	/**
	 * Get descriptionStrings
	 * @return
	 */
	public static Map<String, String> getDescriptionStrings(){
		Map<String, String> descriptionStringsMap = new HashMap<>();
		for (String string : descriptionStrings) {
			String[] splits = string.split(":");
			descriptionStringsMap.put(splits[0], splits[1]);
		}
		return descriptionStringsMap;
	}
	
	/**
	 * The input key words value
	 */
	public final static String[] normalAndBaddescription = {
			"cmtreat:1",
			"shuqian:2",
			"shuhou:3",
			"zhiliaozhong:4",
			"zhiliaohou:5",
			"hualiaozhong:6",
			"hualiaohou:7",
			"fenzi:8",
			"mianyi:9",
		"hanwu:0",
		"hanqing:1",
		"hanzhong:2",
		"rewu:0",
		"reqing:1",
		"rezhong:2",
		"hanre:1",
		"sweat:1",
		"nosweat:0",
		"zihan:2",
		"daohan:3",
		"dahan:4",
		"noxionglei:0",
		"okxionglei:1",
		"badxionglei:2",
		"worsexionglei:3",
		"nofutong:0",
		"okfutong:1",
		"badfutong:2",
		"worsefutong:3",
		"yaotong:1",
		"wantong:1",
		"toutong:1",
		"touyun:1",
		"xinji:1",
		"xiongmen:1",
		"fuzhang:1",
		"wanzhang:1",
		"shenzhong:1",
		"erming:1",
		"muxuan:1",
		"mamu:1",
		"defaultdefecate:0",
		"okdefecate:1",
		"baddefecate:2",
		"worsedefecate:3",
		"blooddefecate:4",
		"xiexie:1",
		"okurinate:0",
		"badurinate:1",
		"worseurinate:2",
		"bloodurinate:3",
		"oktonguecolor:0",
		"whitetonguecolor:1",
		"redtonguecolor:2",
		"jiangtonguecolor:3",
		"purpletonguecolor:4",
		"cyantonguecolor:5",
		"bluetonguecolor:6",
		"whitecoatedtongue:0",
		"yellowcoatedtongue:1",
		"purplecoatedtongue:2",
		"blackcoatedtongue:3",
		"nitaicoatedtongue:4",
		"houtaicoatedtongue:5",
		"oksputumamount:0",
		"littlesputumamount:1",
		"muchsputumamount:2",
		"yellowsputumcolor:3",
		"whitesputumcolor:4",
		"redlittlesputumcolor:1",
		"redmuchsputumcolor:2",
		"redmoresputumcolor:3",
		"oksleep:0",
		"badsleep:1",
		"worsesleep:2",
		"worstsleep:3",
		"somnolencesleep:4",
		"okna:0",
		"badna:1",
		"anorexiana:2",
		"worsena:3",
		"okenergy:0",
		"badenergy:1",
		"worseenergy:2",
		"floatpulse:1",
		"sinkpulse:1",
		"slimpulse:1",
		"roughpulse:1",
		"latepulse:1",
		"numberpulse:1",
		"chordpulse:1",
		"slidepulse:1",
		"okthirst:0",
		"badthirst:1",
		"worsethirst:2",
		"lighttaste:0",
		"acidtaste:1",
		"bittertaste:2",
		"okcough:0",
		"badcough:1",
		"worsecough:2",
		"worstcough:3"
	};
	
	/**
	 * Get normalAndBaddescription
	 * @return
	 */
	public static Map<String, String> getNormalAndBaddescription(){
		
		Map<String, String> normalAndBaddescriptionMap = new HashMap<>();
		for (String string : normalAndBaddescription) {
			String[] splits = string.split(":");
			normalAndBaddescriptionMap.put(splits[0], splits[1]);
		}
		return normalAndBaddescriptionMap;
	}
	
	/**
	 *  The machine learning input description keywords
	 */
	public final static String[] descKeywords = {
		"hanwu:寒无",
		"hanqing:寒轻",
		"hanzhong:寒重",
		"rewu:热无",
		"reqing:热轻",
		"rezhong:热重",
		"hanre:寒热往来",
		"sweat:有汗|汗多，|现汗仍多",
		"nosweat:无汗",
		"zihan:，少气自汗",
		"daohan:盗汗",
		"dahan:大汗",
		"noxionglei:无胸肋痛",
		"okxionglei:左胸轻痛，|胸部疼痛缓解，|咳嗽胸痛减少，|夜间胸痛缓解，|右胸背部隐痛，|，胸痛缓解，|左胸隐痛，|胸部隐痛，|，少许胸痛，|轻度胸肋痛|胸痛缓解|偶胸痛|稍有疼痛|偶有胸痛|胸胁不适轻微|现仍左胸胁不适|，胸闷痛减轻，|现胸背隐痛，",
		"badxionglei:夜间胸痛|现左胸闷不适，|，胸痛，|胸背部疼痛，|现左胸胁不适，|现左胁肋疼痛不适|现左胸疼痛，|现右侧胸背痛，|现左胸背疼痛|现胸背痛|、颈、胸部疼痛|胸肋痛|现头、颈、胸部疼痛｜。头痛骨痛|胸背痛右侧胸痛|胸闷胸痛",
		"worsexionglei:重度胸肋痛|全身骨痛",
		"nofutong:无腹痛",
		"okfutong:轻度腹痛",
		"badfutong:大便时腹痛|现便时腹痛|腹痛",
		"worsefutong:重度腹痛",
		"yaotong:腰痛|，腰酸痛，|腰骶酸痛|现腰痛|仍腰酸口干|，腰椎疼痛｜，腰酸，",
		"wantong:脘痛",
		"toutong:现头痛| 头痛|，偶发头痛|现头、颈、胸部疼痛｜。头痛骨痛|，头晕头痛|头痛骨痛，",
		"touyun:现偶有头晕|现头晕乏力|，头晕头痛",
		"xinji:现心悸|，少气心悸",
		"xiongmen:，胸闷|现胸闷，",
		"fuzhang:腹胀",
		"wanzhang:脘胀",
		"shenzhong:身重",
		"erming:耳鸣",
		"muxuan:目眩",
		"mamu:麻木|，时指麻，",
		"defaultdefecate:无便秘",
		"okdefecate:便秘缓解|大便次数多|大便尚可|大便次多|大便不畅|大便可|大便欠通畅",
		"baddefecate:大便难排|大便欠通畅|，便秘，|，便秘。",
		"worsedefecate:二便失禁|大便难解|时便溏|，便溏，|便溏缓解|便烂|大便时腹痛|大便不畅",
		"blooddefecate:，便血，",
		"xiexie:泻泄|，腹泻（|因腹泻严重|，腹泻，|因腹泻、|，腹泻好转，|时腹泻，|时有腹泻|腹泻缓解|近腹泻，|皮疹腹泻|腹泻减少|，腹泻。|腹泻轻微|、腹泻，",
		"okurinate:二便调|小便调",
		"badurinate:小便次多|小便量少|夜尿多缓解|，夜尿减少",
		"worseurinate:尿频|二便失禁|，夜尿多|现夜尿多，",
		"bloodurinate:尿血",
		"oktonguecolor:淡红正常|舌质淡",
		"whitetonguecolor:淡白",
		"redtonguecolor:舌质红|舌质暗红|舌红苔微黄|舌红苔少",
		"jiangtonguecolor:降色",
		"purpletonguecolor:舌质紫暗",
		"cyantonguecolor:青色",
		"bluetonguecolor:蓝色",
		"whitecoatedtongue:舌苔薄白|舌苔白|舌苔白腻",
		"yellowcoatedtongue:舌苔微黄|舌苔黄|舌红苔微黄|舌淡苔微黄|舌红苔少|舌苔染色",
		"purplecoatedtongue:舌质紫暗",
		"blackcoatedtongue:黑（灰）苔",
		"nitaicoatedtongue:舌苔黄微腻|舌苔黄腻",
		"houtaicoatedtongue:厚苔",
		"oksputumamount:咳嗽无痰|无痰",
		"littlesputumamount:现咳嗽稀痰，|，痰白可咯减少，|有痰难咳，|咳嗽痰多缓解，|，有痰，|现咳嗽痰多缓解，|，痰少|现少咳痰血|，有痰，|咳嗽少痰|咳嗽痰少|咯少量血痰|痰血减少|痰少色白|少痰难咯|量少色黄|少许血丝痰|偶咳少痰|痰减少|少量痰血",
		"muchsputumamount:现痰多难咯，|现咳嗽咯痰，|咽痒咳嗽痰粘，|现咳嗽痰难咯，|，咳嗽咯痰，|现少咳有痰色黄|咳嗽痰多|少咳痰粘|痰白可咯|痰多色黄|黄痰难咯|咯黄白色稀痰|痰黄白|痰浓稠|咽中有痰|痰多色白",
		"yellowsputumcolor:痰多色黄|黄痰难咯|痰黄白|痰色黄难咯|咯黄色稀痰|量少色黄|咯黄痰|咯黄白粘痰|现少咳有痰色黄",
		"whitesputumcolor:现少咳痰白，|咳嗽痰色白|咯黄白痰|痰白可咯|痰少色白|白痰|少白痰|痰多色灰白|咯白痰|痰色白|咳嗽痰白|痰多色白",
		"redlittlesputumcolor:痰血减少|咳嗽咯痰带血丝，|咯血减少，|痰中带血减轻|少许血丝痰|痰中血丝|少量痰血|偶有痰血|现咳嗽痰血缓解|现咳嗽痰血少，",
		"redmuchsputumcolor:现咳嗽咯痰血，|咯少量血痰|痰中带血，|咯血痰|，血痰，|现仍咳嗽血痰",
		"redmoresputumcolor:痰血加重",
		"oksleep:纳寐可|纳眠可|纳差眠可|纳改善眠可",
		"badsleep:纳可眠改善，|纳眠尚可|纳眠一般|纳可眠一般|纳可眠稍差|纳差眠好转|纳可眠好转|眠差改善|纳差眠改善|纳欠佳眠一般|纳眠欠佳|纳差眠欠佳|纳眠好转|纳眠稍差",
		"worsesleep:纳可眠差|纳眠差|纳一般眠差|纳眠俱差|眠差梦多",
		"worstsleep:失眠",
		"somnolencesleep:嗜睡",
		"okna:已无恶心欲呕，|纳寐可|纳眠可|纳可眠一般|纳可眠稍差|纳可眠好转",
		"badna:纳眠尚可|纳眠一般|纳欠佳眠一般|纳一般眠差|纳眠欠佳|纳改善眠可|纳差眠欠佳|纳眠好转|纳眠稍差|纳差眠可|纳眠差|纳差眠好转|纳差眠改善|纳眠俱差",
		"anorexiana:厌食|，恶心欲呕|，时有呕吐|，偶有呕吐",
		"worsena:食欲减退",
		"okenergy:气力正常",
		"badenergy:现少气缓解，|声嘶气促缓解，｜少气好转|少气缓解|偶有少气|活动后气促",
		"worseenergy:声嘶气促缓解，|现仍倦怠乏力|现肢体乏力，|倦怠乏力，|现倦怠乏力，|下肢乏力，|近倦怠乏力|，气促，|乏力，|，少气，|现心悸气短，|：气短腰酸，|现咳嗽少气，|现少气，|现静息下气促，|现少气头晕|现倦怠|现倦怠乏力，|现咳嗽少气|，少气心悸|，胸闷气促，|，困倦乏力，|：倦怠|现乏力倦怠|现疲倦|现气促|少气自汗|少气乏力|现头晕乏力|仍气短|气短盗汗|嗳气|矢气多|现倦怠乏力|现气短|现咳嗽少气|乏力，|，倦怠，",
		"floatpulse:脉浮",
		"sinkpulse:脉沉",
		"slimpulse:脉细|脉弦细|脉细滑",
		"roughpulse:脉粗",
		"latepulse:脉迟",
		"numberpulse:脉数",
		"chordpulse:脉弦|脉弦细|脉弦滑",
		"slidepulse:脉滑|脉弦滑|脉细滑",
		"okthirst:口不渴",
		"badthirst:喝不多饮",
		"worsethirst:口渴多饮|，口干，|仍腰酸口干|现口干，|，夜晚口干|，口干咽痛，",
		"lighttaste:口淡",
		"acidtaste:泛酸",
		"bittertaste:，口苦，",
		"okcough:现无咳嗽咯痰，|咳嗽正常|已无咳嗽|咳嗽已止",
		"badcough:现咳嗽痰血减轻，|现咳嗽痰血少作，|现少咳咯白痰，|现咽痒少咳，|现少咳痰白，|现干咳减轻|现咳嗽痰血少，|咳嗽少作，|现咳嗽痰多缓解，|现少咳痰血|现偶有干咳|，少咳|现少咳有痰色黄|少许咳嗽|咳嗽稍好转|咳嗽缓解|偶有干咳|偶咳嗽|偶咯痰|咳嗽少作|咳嗽好转|咳嗽少|偶有痰血|偶有咳嗽|咳嗽减少|偶咳少痰|偶咳|。现偶咳嗽，",
		"worsecough:：咳嗽，|现咳嗽稀痰，|咽痒咳嗽痰粘，|，咽痒咳嗽，|现咽痒咳嗽，|，咳嗽咯痰，|现咳嗽，|，咳嗽，|现仍咳嗽血痰|，干咳|，饮水呛咳|，咽痒咳嗽|时咳嗽咯痰|咳嗽痰多|咳嗽咽痒|咳嗽少气|咳嗽无痰|少咳痰粘|咳嗽痰少|咯少量血痰|咳嗽痰色白|痰血减少|咯黄白痰|痰白可咯|少痰难咯|黄痰难咯|咯黄白色稀痰|咳嗽胸闷|痰难咯|咯白痰|咯血痰|咳嗽痰白|咯黄色稀痰|咯黄痰|咯黄白粘痰",
		"worstcough:咳嗽频繁|咳嗽反复|咳嗽痰血，|现咳嗽痰血加重，|咳嗽加重|咳嗽较剧"
	};
	
	/**
	 * Get descKeywords
	 * @return
	 */
	public static Map<String, String[]> getDescKeywords(){
		Map<String, String[]> descKeywordsMap = new HashMap<String, String[]>();
		for(String s : descKeywords){
			String[] splits = s.split(":");
			if(splits == null || splits.length != 2){
				continue;
			}
			String[] values = splits[1].split("\\|");
			if(values == null || values.length == 0){
				continue;
			}
			descKeywordsMap.put(splits[0], values);
		}
		return descKeywordsMap;
	}
	
	
	/**
	 * The input items of machine learning 
	 */
	public final static String[] machineKeywords = {
		"shijianzhuangtai%0:cmtreat#1:shuqian#2:shuhou#3:zhiliaozhong#4:zhiliaohou#5:hualiaozhong#6:hualiaohou#7:fenzi#8:mianyi",
		"qixu%1:气虚",
		"tanyu%1:痰瘀",
		"hujie%1:互结",
		"zuluo%1:阻络",
		"qiyinliangxu%1:气阴两虚",
		"pixu%1:脾虚",
		"tanshi%1:痰湿",
		"rejie%1:热结",
		"shiyu%1:湿瘀",
		"jiare%1:夹热",
		"yure%1:瘀热",
		"shizu%1:湿阻",
		"erming%1:erming",
		"qili%0:okenergy#1:badenergy#2:worseenergy",
		"tanse%1:yellowsputumcolor#2:whitesputumcolor#3:redlittlesputumcolor#4:redmuchsputumcolor#5:redmoresputumcolor",
		"maixi%1:slimpulse",
		"tanliang%0:oksputumamount#1:littlesputumamount#2:muchsputumamount",
		"hann%0:hanwu#1:hanqing#2:hanzhong",
		"futong%0:nofutong#1:okfutong#2:badfutong#3:worsefutong",
		"wantong%1:wantong",
		"shenzhong%1:shenzhong",
		"maifu%1:floatpulse",
		"han%0:nosweat#1:sweat#2:zihan#3:daohan#4:dahan",
		"maishu%1:numberpulse",
		"shetai%0:whitecoatedtongue#1:yellowcoatedtongue#2:purplecoatedtongue#3:blackcoatedtongue#4:nitaicoatedtongue#5:houtaicoatedtongue",
		"xiaobian%0:okurinate#1:badurinate#2:worseurinate#3:bloodurinate",
		"xiongleitong%0:noxionglei#1:okxionglei#2:badxionglei#3:worsexionglei",
		"xinji%1:xinji",
		"mamu%1:mamu",
		"xuetan%1:redlittlesputumcolor#2:redmuchsputumcolor#3:redmoresputumcolor",
		"mian%0:oksleep#1:badsleep#2:worsesleep#3:worstsleep#4:somnolencesleep",
		"kesou%0:okcough#1:badcough#2:worsecough#3:worstcough",
		"maichi%1:latepulse",
		"touyun%1:touyun",
		"toutong%1:toutong",
		"re%0:rewu#1:reqing#2:rezhong",
		"xiongmen%1:xiongmen",
		"maichen%1:sinkpulse",
		"hanrewanglai%1:hanrewanglai",
		"maixian%1:chordpulse",
		"dabian%0:defaultdefecate#1:okdefecate#2:baddefecate#3:worsedefecate#4:blooddefecate",
		"na%0:okna#1:badna#2:anorexiana#3:worsena",
		"muxuan%1:muxuan",
		"shese%0:oktonguecolor#1:whitetonguecolor#2:redtonguecolor#3:jiangtonguecolor#4:purpletonguecolor#5:cyantonguecolor#6:bluetonguecolor",
		"fuzhang%1:fuzhang",
		"wanzhang%1:wanzhang",
		"maihua%1:slidepulse",
		"xiexie%1:xiexie",
		"kouwei%0:lighttaste#1:acidtaste#2:bittertaste",
		"yaotong%1:yaotong",
		"kouke%0:okthirst#1:badthirst#2:worsethirst",
		"maicu%1:roughpulse"
	};
	
	/**
	 * order description keywords (no used)
	 */
	public final static String[] descriptionOrderStrings = {
		"na","tonguecolor","coatedtongue","pulse",
		"sputumamount","sputumcolor","cough","defecate",
		"urinate","xonglei","futong","sleep","hanre","sweat",
		"energy","thirst","taste"
	};
	
	/**
	 * The machine learning output medicines 
	 */
	public final static String[] machineMedicine = {
			"甘草","白花蛇舌草","红豆杉","石见穿","薏苡仁","龙葵","党参(太子参)","茅莓根","白术","黄芪","莪术","蛇莓","猫爪草","望江南子","山慈菇","延胡索","连翘","白茅根",
			"制川乌","白英","僵蚕","五味子","黄芩","水牛角","酸枣仁","天麻","预知子","葶苈子","紫珠草","姜制砂仁米","炒稻芽","补骨脂","猪苓","黄精","北沙参","益智",
			"桑白皮","山楂","生地黄","石榴皮","石菖蒲","地肤子","乌梢蛇","金银花","紫苏梗","藕节炭","重楼","石仙桃","豆蔻","肉苁蓉","玄参","有瓜石斛","火麻仁","番泻叶",
			"桔梗","磁石","半枝莲","麦冬","枳实","粉葛","胆南星","山药","枸杞子","田七末","天花粉","法半夏","六神曲","防风","牛蒡子","木蝴蝶","骨碎补","蜜麻黄","泽泻","浮小麦",
			"石上柏","全蝎粉","桑寄生","肉桂","瓜蒌子","苇茎","地榆炭","何首乌","全蝎","旱莲草","佩兰","苦杏仁","芦根","炒麦芽","地骨皮","木香","白芍","女贞子","白芷",
			"虎杖","鸡血藤","三七片","鱼腥草","桑螵蛸","桂枝","麻黄根","郁李仁","益母草","决明子","杜仲","紫苏子","覆盆子","钩藤","柴胡","羚羊角骨","瓜蒌皮","柏子仁",
			"狗脊","菊花","红花","野菊花","威灵仙","独活","灵芝","王不留行","蝉蜕","桑椹","白鲜皮","大枣","升麻","丁香","熟附子","香附","辛夷","苍术","川芎","玉米须","紫草",
			"大黄","丹参","车前草","乌药","木瓜","络石藤","蒲公英","厚朴","槐花","橘核","檀香","香薷","鹿角霜","薤白",
			"当归","小茴香","桑枝","首乌藤","知母","煅龙骨","夏枯草","茯苓","合欢皮","干姜","赤芍","珍珠母","小蓟","青蒿","桃仁","银柴胡","荆芥穗","田基黄"
	};
	
	/**
	 * The machine learning output medicines 
	 */
	public final static String[] statisticsMedicine = {
			"甘草","白花蛇舌草","红豆杉","石见穿","薏苡仁","龙葵","党参","太子参","茅莓根","白术","黄芪","莪术","蛇莓","猫爪草","望江南子","山慈菇","延胡索","连翘","白茅根",
			"制川乌","白英","僵蚕","五味子","黄芩","水牛角","酸枣仁","天麻","预知子","葶苈子","紫珠草","姜制砂仁米","炒稻芽","补骨脂","猪苓","黄精","北沙参","益智",
			"桑白皮","山楂","生地黄","石榴皮","石菖蒲","地肤子","乌梢蛇","金银花","紫苏梗","藕节炭","重楼","石仙桃","豆蔻","肉苁蓉","玄参","有瓜石斛","火麻仁","番泻叶",
			"桔梗","磁石","半枝莲","麦冬","枳实","粉葛","胆南星","山药","枸杞子","田七末","天花粉","法半夏","六神曲","防风","牛蒡子","木蝴蝶","骨碎补","蜜麻黄","泽泻","浮小麦",
			"石上柏","全蝎粉","桑寄生","肉桂","瓜蒌子","苇茎","地榆炭","何首乌","全蝎","旱莲草","佩兰","苦杏仁","芦根","炒麦芽","地骨皮","木香","白芍","女贞子","白芷",
			"虎杖","鸡血藤","三七片","鱼腥草","桑螵蛸","桂枝","麻黄根","郁李仁","益母草","决明子","杜仲","紫苏子","覆盆子","钩藤","柴胡","羚羊角骨","瓜蒌皮","柏子仁",
			"狗脊","菊花","红花","野菊花","威灵仙","独活","灵芝","王不留行","蝉蜕","桑椹","白鲜皮","大枣","升麻","丁香","熟附子","香附","辛夷","苍术","川芎","玉米须","紫草",
			"大黄","丹参","车前草","乌药","木瓜","络石藤","蒲公英","厚朴","槐花","橘核","檀香","香薷","鹿角霜","薤白",
			"当归","小茴香","桑枝","首乌藤","知母","煅龙骨","夏枯草","茯苓","合欢皮","干姜","赤芍","珍珠母","小蓟","青蒿","桃仁","银柴胡","荆芥穗","田基黄"
	};
	
	/**
	 * The sorted code
	 */
	public final static String[] sortCode = {
			"qixu","tanyu","hujie","zuluo","qiyinliangxu","pixu","tanshi","rejie","shiyu","jiare","yure","shizu","erming","qili","tanse","maixi",
			"tanliang","han","futong","shijianzhuangtai","wantong","shenzhong","maifu","maishu","han","shetai","xiaobian","xiongleitong","xinji",
			"mamu","xuetan","kesou","mian","maichi","touyun","toutong","re","xiongmen",
			"maichen","hanrewanglai","xiexie","maixian","na","dabian","muxuan","shese","fuzhang","maihua","wanzhang","kouwei","kouke","yaotong","maicu"
	};
	
	/**
	 * Main project strings
	 */
	public final static String[] mainProjectStrings = {"tanliang","tanse","kesou","maicu","maihua","maixian","maichen","maichi","maishu","maifu","maixi","na","dabian","xiexie","xiaobian","xiongleitong","futong"};
	
	/**
	 * Second project strings
	 */
	public final static String[] secondProjectStrings = {"yaotong","wantong","toutong","touyun","xinji","xiongmen","fuzhang","wanzhang","shenzhong","erming","muxuan","mamu","shese","shetai","qili","mian","hanre","re","hann","han","kouke","kouwei"};
	
	/**
	 * The main description key words
	 */
	public final static String[] mainDescriptionStrings = {"badna","anorexiana","worsena","okdefecate","baddefecate","worsedefecate","badurinate","worseurinate","bloodurinate","okxonglei","badxonglei","worsexonglei","okfutong","badfutong","worsefutong","littlesputumamount","muchsputumamount","yellowsputumcolor","whitesputumcolor",
			"slimpulse","floatpulse","sinkpulse","roughpulse","latepulse","numberpulse","chordpulse","slidepulse",
			"redlittlesputumcolor","redmuchsputumcolor","redmoresputumcolor","badcough","worsecough","worstcough" }; // 主要症状
	/**
	 * The second description key words
	 */
	public final static String[] seconddescriptionStrings = {"xiexie",
			"yaotong","wantong","toutong","touyun","xinji","xiongmen","fuzhang","wanzhang","shenzhong","erming","muxuan","mamu","whitetonguecolor","redtonguecolor","jiangtonguecolor","purpletonguecolor","cyantonguecolor","bluetonguecolor","yellowcoatedtongue",
			"purplecoatedtongue","blackcoatedtongue","nitaicoatedtongue","houtaicoatedtongue","badenergy","worseenergy","badsleep","worsesleep","worstsleep","somnolencesleep",
			"hanqing","hanzhong","rewu","reqing","rezhong","hanre","sweat","zihan","daohan","dahan","badthirst","worsethirst","acidtaste","bittertaste" }; // 次要症状
	
	public final static String[]  thirddescriptionStrings = { }; // 第三症状描述
	/**
	 * The diagnose key words
	 */
	public final static String[] diagKeywords = {"气虚","痰瘀","互结","阻络","气阴两虚","脾虚","痰湿","热结",	"湿瘀",	"夹热",	"瘀热",	"湿阻"};
	
	/**
	 * 8 main description key words
	 */
	public final static String[] sleepBiasArray = {"badsleep","worsesleep","worstsleep","somnolencesleep"};
	//
	public static List<String> getSleepBiasArray(){
		List<String> list = new ArrayList<String>();
		for (String string : sleepBiasArray) {
			list.add(string);
		}
		return list;
	}
	public final static String[] naBiasArray = {"badna","anorexiana","worsena"};
	//
	public static List<String> getNaBiasArray(){
		List<String> list = new ArrayList<String>();
		for (String string : naBiasArray) {
			list.add(string);
		}
		return list;
	}
	public final static String[] bloodSputumBiasArray = {"redlittlesputumcolor","redmuchsputumcolor","redmoresputumcolor"};
	//
	public static List<String> getBloodSputumBiasArray(){
		List<String> list = new ArrayList<String>();
		for (String string : bloodSputumBiasArray) {
			list.add(string);
		}
		return list;
	}
	public final static String[] xiongLeiBiasArray = {"okxionglei","badxionglei","worsexionglei"};
	//
	public static List<String> getXiongLeiBiasArray(){
		List<String> list = new ArrayList<String>();
		for (String string : xiongLeiBiasArray) {
			list.add(string);
		}
		return list;
	}
	public final static String[] qiliBiasArray = {"badenergy","worseenergy"};
	//
	public static List<String> getQiliBiasArray(){
		List<String> list = new ArrayList<String>();
		for (String string : qiliBiasArray) {
			list.add(string);
		}
		return list;
	}
	public final static String[] coughBiasArray = {"badcough","worsecough","worstcough"};
	//
	public static List<String> getCoughBiasArray(){
		List<String> list = new ArrayList<String>();
		for (String string : coughBiasArray) {
			list.add(string);
		}
		return list;
	}
	public final static String[] defecateBiasArray = {"okdefecate","baddefecate","worsedefecate","blooddefecate"};
	//
	public static List<String> getDefecateBiasArray(){
		List<String> list = new ArrayList<String>();
		for (String string : defecateBiasArray) {
			list.add(string);
		}
		return list;
	}
	public final static String[] fuxieBiasArray = {"xiexie"};
	//
	public static List<String> getFuxieBiasArray(){
		List<String> list = new ArrayList<String>();
		for (String string : fuxieBiasArray) {
			list.add(string);
		}
		return list;
	}

}
