// testlog4cpp.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"
#include "log4cpp/Category.hh"
#include "log4cpp/FileAppender.hh"
#include "log4cpp/BasicLayout.hh"
#include "log4cpp/PropertyConfigurator.hh"

int _tmain(int argc, _TCHAR* argv[])
{
	try
	{
		log4cpp::PropertyConfigurator::configure("log4cpp.properties");
	}
	catch (log4cpp::ConfigureFailure &f)
	{
		std::cerr << "configure problem " << f.what() << std::endl;
	}

	// 用 sample
	log4cpp::Category &log1 = log4cpp::Category::getInstance(std::string("sample"));
	log1.debug("test debug log");
	log1.info("test info log");

	// 用 sample.son
	log4cpp::Category &log2 = log4cpp::Category::getInstance(std::string("sample.son"));
	log2.debug("test debug log of son");
	log2.info("test info log of son");

	// 用 sample.daughter
	log4cpp::Category &log3 = log4cpp::Category::getInstance(std::string("sample.daughter"));
	log3.debug("test debug log of daughter");
	log3.info("test info log of daughter");

	return 0;
}

