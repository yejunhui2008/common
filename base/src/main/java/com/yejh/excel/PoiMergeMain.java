package com.yejh.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

public class PoiMergeMain {
	public static void main(String[] args) {

		String strPath = "E:\\test\\excel\\input";//excel存放路径
		File file = new File(strPath);
		HSSFWorkbook[] workbooks = new HSSFWorkbook[file.listFiles().length];
		for (int i = 0; i < file.listFiles().length; i++) {
			try {
				workbooks[i] = ReadExcel(strPath, file.listFiles()[i].getName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		HSSFWorkbook out = mergeHSSFWorkbooks(workbooks);

		// 新的excel 文件名
		String excelName = "合并文件";
		String outPath = "E:\\test\\excel\\output\\";//保存新EXCEL路径
//		File fileOut = new File(outPath + excelName + ".xls");
		try {
			FileOutputStream fileOut = new FileOutputStream(outPath + excelName + ".xls");
			out.write(fileOut);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//		fileOut.close();
	}

	/**
	* strPath 文件夹路径名
	* name　　 excel文件名
	*/
	private static HSSFWorkbook ReadExcel(String strPath, String name)
			throws IOException {

		// 打开已有的excel
		String strExcelPath = strPath + "\\" + name;
		InputStream in = new FileInputStream(strExcelPath);

		return new HSSFWorkbook(in);
	}

	/**
	 * @param destWorkBook 目标workbook
	 * @param sourceWorkBook 源workbook
	 * @param sourceSheet 源sheet
	 * @param targetSheet 目sheet
	 * @param pStartRow 起始读取行
	 * @param pEndRow 结束读取行
	 * @param pPosition 目标保存
	*/

	public static void copyRows(HSSFWorkbook destWorkBook, HSSFWorkbook sourceWorkBook, HSSFSheet sourceSheet, HSSFSheet targetSheet, int pStartRow,
			int pEndRow, int pPosition) {
		HSSFRow sourceRow = null;
		HSSFRow targetRow = null;
		HSSFCell sourceCell = null;
		HSSFCell targetCell = null;
		int cType;
		int i;
		int j;
		int targetRowFrom;
		int targetRowTo;
		if ((pStartRow == -1) || (pEndRow == -1)) {
			return;
		}
		List<CellRangeAddress> oldRanges = new ArrayList<CellRangeAddress>();

		for (i = 0; i < sourceSheet.getNumMergedRegions(); i++) {
			oldRanges.add(sourceSheet.getMergedRegion(i));
		}

		// 拷贝合并的单元格。原理：复制当前合并单元格后，原位置的格式会移动到新位置，需在原位置生成旧格式
		for (int k = 0; k < oldRanges.size(); k++) {
			CellRangeAddress oldRange = oldRanges.get(k);
			//			CellRangeAddress newRange = new CellRangeAddress(oldRange
			//					.getFirstRow(), oldRange.getLastRow(), oldRange
			//							.getFirstColumn(),
			//					oldRange.getLastColumn());
			//			if (oldRange.getFirstRow() >= pStartRow
			//					&& oldRange.getLastRow() <= pEndRow) {
			targetRowFrom = oldRange.getFirstRow() - pStartRow + pPosition;
			targetRowTo = oldRange.getLastRow() - pStartRow + pPosition;
			oldRange.setFirstRow(targetRowFrom);
			oldRange.setLastRow(targetRowTo);
			targetSheet.addMergedRegion(oldRange);
			//				sourceSheet.addMergedRegion(newRange);
			//			}

		}

		// 设置列宽
		for (i = pStartRow; i <= pEndRow; i++) {
			sourceRow = sourceSheet.getRow(i);
			if (sourceRow != null) {
				for (j = sourceRow.getFirstCellNum(); j <= sourceRow.getPhysicalNumberOfCells(); j++) {
					targetSheet.setColumnWidth(j, (int) (sourceSheet.getColumnWidth(j) + 0.72 * 256));
					targetSheet.setColumnHidden(j, false);
				}
				break;
			}
		}

		// 拷贝行并填充数据
		for (; i <= pEndRow; i++) {
			sourceRow = sourceSheet.getRow(i);
			if (sourceRow == null) {
				continue;
			}

			targetRow = targetSheet.createRow(i - pStartRow + pPosition);
			targetRow.setHeight(sourceRow.getHeight());

			for (j = sourceRow.getFirstCellNum(); j <= sourceRow.getPhysicalNumberOfCells(); j++) {
				sourceCell = sourceRow.getCell(j);

				if (sourceCell == null) {
					continue;
				}
				targetCell = targetRow.createCell(j);

				//样式的设置
				HSSFCellStyle cStyle = destWorkBook.createCellStyle();
				cStyle.cloneStyleFrom(sourceCell.getCellStyle());
				targetCell.setCellStyle(cStyle);
				cType = sourceCell.getCellType();
				targetCell.setCellType(cType);

				switch (cType) {
				case HSSFCell.CELL_TYPE_BOOLEAN:
					targetCell.setCellValue(sourceCell.getBooleanCellValue());
					// System.out.println("--------TYPE_BOOLEAN:"+ targetCell.getBooleanCellValue());
					break;
				case HSSFCell.CELL_TYPE_ERROR:
					targetCell.setCellErrorValue(sourceCell.getErrorCellValue());
					// System.out.println("--------TYPE_ERROR:"+ targetCell.getErrorCellValue());
					break;
				case HSSFCell.CELL_TYPE_FORMULA:
					// parseFormula这个函数的用途在后面说明
					targetCell.setCellFormula(parseFormula(sourceCell.getCellFormula()));
					// System.out.println("--------TYPE_FORMULA:"+ targetCell.getCellFormula());
					break;
				case HSSFCell.CELL_TYPE_NUMERIC:
					targetCell.setCellValue(sourceCell.getNumericCellValue());
					// System.out.println("--------TYPE_NUMERIC:"+ targetCell.getNumericCellValue());
					break;
				case HSSFCell.CELL_TYPE_STRING:
					targetCell.setCellValue(sourceCell.getRichStringCellValue());
					// System.out.println("--------TYPE_STRING:"+ i + targetCell.getRichStringCellValue());
					break;

				}

			}

		}

	}

	/**
	
	 * 处理公式
	
	 * @param pPOIFormula
	
	 * @return
	
	*/

	private static String parseFormula(String pPOIFormula) {
		final String cstReplaceString = "ATTR(semiVolatile)"; //$NON-NLS-1$
		StringBuffer result = null;
		int index;
		result = new StringBuffer();
		index = pPOIFormula.indexOf(cstReplaceString);
		if (index >= 0) {
			result.append(pPOIFormula.substring(0, index));
			result.append(pPOIFormula.substring(index + cstReplaceString.length()));
		} else {
			result.append(pPOIFormula);
		}
		return result.toString();

	}

	public static HSSFWorkbook mergeHSSFWorkbooks(HSSFWorkbook[] workbooks) {
		if (workbooks == null || workbooks.length == 0) {
			return null;
		} else if (workbooks.length == 1) {
			return workbooks[0];
		}
		int n = 1;
		HSSFWorkbook hwb = new HSSFWorkbook();
		for (int i = 0; i < workbooks.length; i++) {
			HSSFWorkbook wb = workbooks[i];
			for (int j = 0; j < wb.getNumberOfSheets(); j++) {
				HSSFSheet fromsheet = wb.getSheetAt(j);
				copyRows(hwb, wb, fromsheet, hwb.createSheet("sheet" + n), fromsheet.getFirstRowNum(), fromsheet.getLastRowNum(), 0);
				n++;
			}
		}

		return hwb;

	}
}
