#ifndef _TEST1_MODULE_H_
#define _TEST1_MODULE_H_

#ifdef WIN32
#   ifdef TEST1_EXPORTS
#       define TEST1_API __declspec(dllexport)
#   else
#       define TEST1_API __declspec(dllimport)
#   endif
#else
#   define TEST1_API
#endif

#endif






