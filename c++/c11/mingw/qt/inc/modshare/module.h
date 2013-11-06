#ifndef _MODULE_H_
#define _MODULE_H_

#ifdef WIN32
#   ifdef MODULE_EXPORTS
#       define MODULE_API __declspec(dllexport)
#   else
#       define MODULE_API __declspec(dllimport)
#   endif
#else
#   define MODULE_API
#endif

#endif






